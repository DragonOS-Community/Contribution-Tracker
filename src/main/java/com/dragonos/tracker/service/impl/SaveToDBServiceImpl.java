package com.dragonos.tracker.service.impl;

import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;
import com.dragonos.tracker.service.SaveToDBService;

import java.util.List;

public class SaveToDBServiceImpl implements SaveToDBService {
    @Override
    public int saveProjects() {
        // Step1：取出所有的project数据

        // Step2: 取出相应的pr和issue数据

        // Step3: 将pr_num和issue_num放入到project数据当中

        // Step4: 查询数据库中所有project数据，是否存在相关数据，相关数据是否产生变动

        // Step5: 更新数据库
        return 0;
    }

    @Override
    public int savePrInfo(PrInfo prInfo, Contributor contributor, Project project) {
        // Step1:
        return 0;
    }

    @Override
    public int saveIssueInfo(IssueInfo issueInfo, Contributor contributor, Project project) {
        return 0;
    }

    @Override
    public int saveContributor(List<Contributor> list) {
        return 0;
    }

}
