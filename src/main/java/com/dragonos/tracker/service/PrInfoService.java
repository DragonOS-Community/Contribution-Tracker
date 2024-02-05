package com.dragonos.tracker.service;

import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;

import java.util.List;

/**
 * <p>
 * pr信息表 服务类
 * </p>
 *
 * @author yummy
 * @since 2024-01-30
 */
public interface PrInfoService{
    PageResult<PrInfo> queryPrInfoByContributor(PageParams pageParams, Contributor contributor);
    PageResult<PrInfo> queryPrInfoByProject(PageParams pageParams,Project project);
    PageResult<PrInfo> queryPrInfoByName(PageParams pageParams,String name);
}
