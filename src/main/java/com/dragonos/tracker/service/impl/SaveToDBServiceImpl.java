package com.dragonos.tracker.service.impl;

import com.dragonos.tracker.config.GithubConfig;
import com.dragonos.tracker.mapper.ContributorMapper;
import com.dragonos.tracker.mapper.IssueInfoMapper;
import com.dragonos.tracker.mapper.PrInfoMapper;
import com.dragonos.tracker.mapper.ProjectMapper;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;
import com.dragonos.tracker.service.SaveToDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SaveToDBServiceImpl implements SaveToDBService {
    @Autowired
    GithubConfig githubConfig;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    PrInfoMapper prInfoMapper;
    @Autowired
    IssueInfoMapper issueInfoMapper;
    @Autowired
    ContributorMapper contributorMapper;

    List<Project> projectList;
//    Map<String, List<PrInfo>> prInfoMap = new HashMap<>();
//    Map<String, List<IssueInfo>> issueInfoMap= new HashMap<>();
//    Map<String, List<Contributor>> contributorMap = new HashMap<>();
    List<PrInfo> prInfoList = new ArrayList<>();
    List<IssueInfo> issueInfoList = new ArrayList<>();
    List<Contributor> contributorList = new ArrayList<>();


    String owner = "DragonOS-Community";

    public SaveToDBServiceImpl() {
        // Step1：取出所有的project数据
        projectList = githubConfig.getProjectFromGithub(owner);
        // Step2: 取出相应的pr和issue数据
        for (Project project : projectList) {
            String repo = project.getName();
            String projectId = project.getProjectId();
            List<PrInfo> prInfoListNew = new ArrayList<>();
            prInfoListNew.addAll(githubConfig.getPrFromRepo(owner, repo, 0));
            prInfoListNew.addAll(githubConfig.getPrFromRepo(owner, repo, 1));
            project.setPrNum(prInfoListNew.size());

            List<IssueInfo> issueInfoListNew = new ArrayList<>();
            issueInfoListNew.addAll(githubConfig.getIssueFromRepo(owner, repo, projectId, 0));
            issueInfoListNew.addAll(githubConfig.getIssueFromRepo(owner, repo, projectId, 1));
            project.setIssueNum(issueInfoListNew.size());

            project.setHot(prInfoListNew.size() + issueInfoListNew.size());
            // contributor当中还需要有每个项目的pr数和num数
            List<Contributor> contributorListNew = githubConfig.getContributorFromRepo(owner, repo, projectId);
            // 遍历pr和issue来计算prNum和issueNum
            for (Contributor contributor : contributorListNew) {
                String name = contributor.getName();
                int prNum = 0;
                for (PrInfo prInfo : prInfoListNew) {
                    if (prInfo.getContributorName().equals(name)) {
                        prNum++;
                    }
                }
                contributor.setPrNum(prNum);
                int issueNum = 0;
                for (IssueInfo issueInfo : issueInfoListNew) {
                    if (issueInfo.getContributorName().equals(name)) {
                        issueNum++;
                    }
                }
                contributor.setIssueNum(issueNum);
            }

            prInfoList.addAll(prInfoListNew);
            issueInfoList.addAll(issueInfoListNew);
            contributorList.addAll(contributorListNew);
        }
    }

    @Override
    public int saveProjects() {
        // Step1: truncate表中所有的内容
        projectMapper.clearTable();
        // Step2: 将数据保存到数据库
        int result = 1;
        for (Project project : projectList) {
            int i = projectMapper.insert(project);
            result = Math.min(result, i);
        }
        return result;
    }

    @Override
    public int savePrInfo() {
        // Step1: truncate表中所有的内容
        prInfoMapper.clearTable();
        // Step2: 将数据保存到数据库
        int result = 1;
        for (PrInfo prInfo : prInfoList) {
            int insert = prInfoMapper.insert(prInfo);
            result = Math.min(result, insert);
        }

        return result;
    }

    @Override
    public int saveIssueInfo() {
        // Step1: truncate表中所有的内容
        projectMapper.clearTable();
        // Step2: 将数据保存到数据库
        int result = 1;
        for (IssueInfo issueInfo : issueInfoList) {
            int insert = issueInfoMapper.insert(issueInfo);
            result = Math.min(result, insert);
        }
        return result;
    }

    @Override
    public int saveContributor() {
        // Step1: truncate表中所有的内容
        projectMapper.clearTable();
        // Step2: 将数据保存到数据库
        int result = 1;
        for (Contributor contributor : contributorList) {
            int i = contributorMapper.insert(contributor);
            result = Math.min(result, i);
        }
        return result;
    }

}
