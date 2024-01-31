package com.dragonos.tracker.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.pojo.Project;

import java.util.List;

/**
 * <p>
 * 社区项目表 服务类
 * </p>
 *
 * @author yummy
 * @since 2024-01-30
 */
public interface ProjectService{
    // 查询所有的项目
    List<Project> queryAllProjects();
    // 按页查询项目
    PageResult<Project> queryProjectsByPage(PageParams pageParams);
    // 按名称模糊查询项目
    PageResult<Project> queryProjectsByName(PageParams pageParams, String name);
    // 保存project
    int saveProjects();
}
