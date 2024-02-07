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

    /**
     * 项目github id
     */
    private String projectId;

    private Integer state;

    /**
     * pr提交时间
     */
    private String createdAt;

    /**
     * pr的update时间
     */
    private String updatedAt;


}
