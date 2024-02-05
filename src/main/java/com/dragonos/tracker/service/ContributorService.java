package com.dragonos.tracker.service;

import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.pojo.Contributor;

import java.util.List;

/**
 * <p>
 * 个人贡献表 服务类
 * </p>
 *
 * @author yummy
 * @since 2024-01-30
 */
public interface ContributorService{
    // 按页搜索Contributor
    PageResult<Contributor> queryContributorByPage(PageParams pageParams);

}
