package com.dragonos.tracker.service;

import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;

import java.util.List;

public interface SaveToDBService {
    int saveProjects();
    int savePrInfo(PrInfo prInfo, Contributor contributor, Project project);
    int saveIssueInfo(IssueInfo issueInfo, Contributor contributor, Project project);
    // 向数据库中插入数据
    int saveContributor(List<Contributor> list);
}
