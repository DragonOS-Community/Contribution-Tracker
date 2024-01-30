package com.dragonos.tracker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 社区项目表
 * </p>
 *
 * @author yummy
 */
@Data
@TableName("ct_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ⾃增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 项目全名
     */
    private String fullName;

    /**
     * 项目地址
     */
    private String htmlUrl;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 项目update时间
     */
    private LocalDateTime updatedAt;

    /**
     * 项目所选协议
     */
    private String license;

    /**
     * fork数
     */
    private Integer forksCount;

    /**
     * star数
     */
    private Integer stargazersCount;

    /**
     * watcher数
     */
    private Integer watchersCount;

    /**
     * 该项目的pr数量
     */
    private Integer prNum;

    /**
     * 项目的issue数量
     */
    private Integer issueNum;

    /**
     * 热度评价指标
     */
    private Integer hot;


}
