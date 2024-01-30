package com.dragonos.tracker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 个人贡献表
 * </p>
 *
 * @author yummy
 */
@Data
@TableName("ct_contributor")
public class Contributor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ⾃增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户提交的pr数量
     */
    private Integer prNum;

    /**
     * 用户提交的issue数量
     */
    private Integer issueNum;

    /**
     * 用户的贡献量
     */
    private Integer contributions;


}
