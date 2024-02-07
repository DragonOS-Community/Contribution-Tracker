package com.dragonos.tracker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * issue信息表
 * </p>
 *
 * @author yummy
 */
@Data
@TableName("ct_issue_info")
public class IssueInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ⾃增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 贡献者id
     */
    private String contributorId;

    /**
     * 贡献者用户名
     */
    private String contributorName;

    /**
     * issue名称
     */
    private String title;

    /**
     * issue提交时间
     */
    private String createdAt;

    /**
     * issue的update时间
     */
    private String updatedAt;

    /**
     * issue具体信息地址
     */
    private String htmlUrl;

    /**
     * 对应项目id
     */
    private String projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 状态，1为open，0为close
     */
    private Integer state;


}
