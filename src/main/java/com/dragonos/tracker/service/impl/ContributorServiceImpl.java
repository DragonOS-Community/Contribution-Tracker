package com.dragonos.tracker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.mapper.ContributorMapper;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.service.ContributorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人贡献表 服务实现类
 * </p>
 *
 * @author yuman
 */
@Slf4j
@Service
public class ContributorServiceImpl implements ContributorService {
    @Autowired
    ContributorMapper contributorMapper;
    @Override
    public PageResult<Contributor> queryContributorForAllProject(PageParams pageParams) {
        // 获取数据列表
        List<Contributor> pageResult = contributorMapper.selectAllByAllProject(pageParams);
        long total = pageResult.size();
        // 构建结果集
        PageResult<Contributor> result = new PageResult(pageResult, total, pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<Contributor> queryContributorForAProject(PageParams pageParams, String projectId) {
        LambdaQueryWrapper<Contributor> queryWrapper = new LambdaQueryWrapper<>();
        Page<Contributor> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        queryWrapper.eq(Contributor::getProjectId, projectId);
        // 获取数据列表
        Page<Contributor> pageResult = contributorMapper.selectPage(page, queryWrapper);
        List<Contributor> list = pageResult.getRecords();
        long total = pageResult.getTotal();
        // 构建结果集
        PageResult<Contributor> result = new PageResult(list, total, pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }


}
