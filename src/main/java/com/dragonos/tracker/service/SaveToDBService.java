package com.dragonos.tracker.service;

import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;

import java.util.List;

public interface SaveToDBService {
    int saveProjects();
    int savePrInfo();
    int saveIssueInfo();
    int saveContributor();
}
