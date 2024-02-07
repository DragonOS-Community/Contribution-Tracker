package com.dragonos.tracker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.mapper.IssueInfoMapper;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;
import com.dragonos.tracker.service.IssueInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * issue信息表 服务实现类
 * </p>
 *
 * @author yummy
 */
@Slf4j
@Service
public class IssueInfoServiceImpl implements IssueInfoService {
    @Autowired
    IssueInfoMapper issueInfoMapper;


    @Override
    public PageResult<IssueInfo> queryIssueInfoByContributor(PageParams pageParams, String contibutorId) {
        Page<IssueInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<IssueInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(IssueInfo::getContributorId, contibutorId);
        Page<IssueInfo> issueInfoPage = issueInfoMapper.selectPage(page, queryWrapper);
        PageResult<IssueInfo> result = new PageResult<>(issueInfoPage.getRecords(), issueInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<IssueInfo> queryIssueInfoByProject(PageParams pageParams,String projectId) {
        Page<IssueInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<IssueInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(IssueInfo::getProjectId, projectId);
        Page<IssueInfo> issueInfoPage = issueInfoMapper.selectPage(page, queryWrapper);
        PageResult<IssueInfo> result = new PageResult<>(issueInfoPage.getRecords(), issueInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<IssueInfo> queryIssueInfoByName(PageParams pageParams, String name) {
        Page<IssueInfo> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<IssueInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(IssueInfo::getTitle, name);
        Page<IssueInfo> issueInfoPage = issueInfoMapper.selectPage(page, queryWrapper);
        PageResult<IssueInfo> result = new PageResult<>(issueInfoPage.getRecords(), issueInfoPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }
}
