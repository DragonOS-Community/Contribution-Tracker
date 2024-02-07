package com.dragonos.tracker.service;

import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.config.PageResult;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.Project;

/**
 * <p>
 * issue信息表 服务类
 * </p>
 *
 * @author yummy
 * @since 2024-01-30
 */
public interface IssueInfoService{

    PageResult<IssueInfo> queryIssueInfoByContributor(PageParams pageParams, String contibutorId);
    PageResult<IssueInfo> queryIssueInfoByProject(PageParams pageParams,String projectId);
    PageResult<IssueInfo> queryIssueInfoByName(PageParams pageParams,String name);

}
