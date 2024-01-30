package com.dragonos.tracker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * pr信息表
 * </p>
 *
 * @author yummy
 */
@Data
@TableName("ct_pr_info")
public class PrInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ⾃增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 贡献者id
     */
    private Integer contributorId;

    /**
     * 贡献者用户名
     */
    private String contributorName;

    /**
     * pr名称
     */
    private String title;

    /**
     * pr提交时间
     */
    private LocalDate createdAt;

    /**
     * pr的update时间
     */
    private LocalDate updatedAt;

    /**
     * pr具体信息地址
     */
    private String htmlUrl;

    /**
     * 对应项目id
     */
    private Integer projectId;

    /**
     * 项目名
     */
    private String projectName;


}
