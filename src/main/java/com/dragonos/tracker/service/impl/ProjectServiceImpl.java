package com.dragonos.tracker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragonos.tracker.config.GithubConfig;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.mapper.ProjectMapper;
import com.dragonos.tracker.pojo.Project;
import com.dragonos.tracker.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 社区项目表 服务实现类
 * </p>
 *
 * @author yummy
 */
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public PageResult<Project> queryProjectsByPage(PageParams pageParams) {
        Page<Project> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<Project> projectPage = projectMapper.selectPage(page, null);
        PageResult<Project> result = new PageResult(projectPage.getRecords(), projectPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

    @Override
    public PageResult<Project> queryProjectsByName(PageParams pageParams, String name) {
        Page<Project> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Project::getName, name);
        Page<Project> projectPage = projectMapper.selectPage(page, queryWrapper);
        PageResult<Project> result = new PageResult(projectPage.getRecords(), projectPage.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        return result;
    }

}
