package com.dragonos.tracker.config;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dragonos.tracker.pojo.Contributor;
import com.dragonos.tracker.pojo.IssueInfo;
import com.dragonos.tracker.pojo.PrInfo;
import com.dragonos.tracker.pojo.Project;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class GithubConfig {
    @Bean
    public GithubConfig githubConfig(){
        return new GithubConfig();
    }

    public String toDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(time, formatter);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedZonedDateTime = formatter.format(zonedDateTime);
        return formattedZonedDateTime;
    }
    public List<PrInfo> getPrFromRepo(String owner, String repo) {
        OkHttpClient client = new OkHttpClient();
        // 构建API请求URL
        String prUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/" + "pulls";
        // 创建HTTP请求
        Request.Builder requestBuilder = new Request.Builder()
                .url(prUrl);
        Request request = requestBuilder.build();
        List<PrInfo> result = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // 获取对应项目的pr数量及具体信息
                JSONArray jsonArray = JSON.parseArray(responseBody);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    PrInfo prInfo = new PrInfo();
                    prInfo.setTitle(jsonObject.getString("title"));
                    prInfo.setHtmlUrl(jsonObject.getString("html_url"));

                    JSONObject user = jsonObject.getJSONObject("user");
                    prInfo.setContributorName(user.getString("login"));
                    prInfo.setProjectName(repo);
                    prInfo.setCreatedAt(toDateTime(jsonObject.getString("created_at")));
                    prInfo.setUpdatedAt(toDateTime(jsonObject.getString("updated_at")));
                    result.add(prInfo);
                }
            } else {
                System.out.println("获取" + owner + "/" + repo + " PR 请求失败：" + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<IssueInfo> getIssueFromRepo(String owner, String repo) {
        OkHttpClient client = new OkHttpClient();
        // 构建API请求URL
        String prUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/" + "issues";
        // 创建HTTP请求
        Request.Builder requestBuilder = new Request.Builder()
                .url(prUrl);
        Request request = requestBuilder.build();
        List<IssueInfo> result = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // 获取对应项目的pr数量及具体信息
                JSONArray jsonArray = JSON.parseArray(responseBody);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.containsKey("pull_request")) continue;
                    IssueInfo issueInfo = new IssueInfo();
                    issueInfo.setTitle(jsonObject.getString("title"));
                    issueInfo.setHtmlUrl(jsonObject.getString("html_url"));

                    JSONObject user = jsonObject.getJSONObject("user");
                    issueInfo.setContributorId(user.getInteger("id"));
                    issueInfo.setContributorName(user.getString("login"));

                    issueInfo.setProjectName(repo);
                    issueInfo.setCreatedAt(toDateTime(jsonObject.getString("created_at")));
                    issueInfo.setUpdatedAt(toDateTime(jsonObject.getString("updated_at")));
                    result.add(issueInfo);
                }
            } else {
                System.out.println("获取" + owner + "/" + repo + "issues 请求失败：" + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



    public List<Project> getProjectFromGithub(String owner) {
        OkHttpClient client = new OkHttpClient();
        // 构建API请求URL
        String apiUrl = "https://api.github.com/users/" + owner + "/repos";
        // 创建HTTP请求
        Request.Builder requestBuilder = new Request.Builder()
                .url(apiUrl);
        Request request = requestBuilder.build();
        List<Project> projectList = new ArrayList<>();
        try {
            // 发送请求并获取响应
            Response response = client.newCall(request).execute();
            // 处理响应数据
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // 这里需要获取每个项目的issue数目和pr数目
                JSONArray jsonArray = JSON.parseArray(responseBody);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.getString("name").equals(".github"))
                        continue;
                    Project project = new Project();
                    project.setName(jsonObject.getString("name"));
                    project.setFullName(jsonObject.getString("full_name"));
                    project.setHtmlUrl(jsonObject.getString("html_url"));
                    project.setDescription(jsonObject.getString("description"));
                    projectList.add(project);
                }
            } else {
                System.out.println("获取" + owner + "project 请求失败：" + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public List<Contributor> getContributorFromRepo(String owner, String repo) {
        OkHttpClient client = new OkHttpClient();
        // 构建API请求URL
        String apiUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/" + "/contributors";
        // 创建HTTP请求
        Request.Builder requestBuilder = new Request.Builder()
                .url(apiUrl);
        Request request = requestBuilder.build();
        List<Contributor> result = new ArrayList<>();
        try {
            // 发送请求并获取响应
            Response response = client.newCall(request).execute();
            // 处理响应数据
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // 这里需要获取每个项目的issue数目和pr数目
                JSONArray jsonArray = JSON.parseArray(responseBody);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Contributor contributor = new Contributor();
                    contributor.setName(jsonObject.getString("login"));
                    contributor.setContributions(jsonObject.getInteger("contributions"));
                    result.add(contributor);
                }
            } else {
                System.out.println("获取" + owner + "/" + repo + " Contributor请求失败：" + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
