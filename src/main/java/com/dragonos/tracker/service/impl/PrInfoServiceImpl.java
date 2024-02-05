package com.dragonos.tracker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.mapper.PrInfoMapper;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;
import com.dragonos.tracker.service.PrInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * pr信息表 服务实现类
 * </p>
 *
 * @author yummy
 */
@Slf4j
@Service
public class PrInfoServiceImpl implements PrInfoService {
    @Autowired
    PrInfoMapper prInfoMapper;


    @Override
    public PageResult<PrInfo> queryPrInfoByContributor(PageParams pageParams, Contributor contributor) {
        Page<PrInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<PrInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PrInfo::getContributorId, contributor.getId());
        Page<PrInfo> prInfoPage = prInfoMapper.selectPage(page, queryWrapper);
        PageResult<PrInfo> result = new PageResult<>(prInfoPage.getRecords(), prInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<PrInfo> queryPrInfoByProject(PageParams pageParams, Project project) {
        Page<PrInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<PrInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PrInfo::getProjectId, project.getId());
        Page<PrInfo> prInfoPage = prInfoMapper.selectPage(page, queryWrapper);
        PageResult<PrInfo> result = new PageResult<>(prInfoPage.getRecords(), prInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<PrInfo> queryPrInfoByName(PageParams pageParams, String name) {
        Page<PrInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<PrInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(PrInfo::getTitle, name);
        Page<PrInfo> prInfoPage = prInfoMapper.selectPage(page, queryWrapper);
        PageResult<PrInfo> result = new PageResult<>(prInfoPage.getRecords(), prInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

}
