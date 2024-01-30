package com.dragonos.tracker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 证书信息
 * </p>
 *
 * @author yummy
 */
@Data
@TableName("ct_certificate")
public class Certificate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ⾃增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 证书对应地址
     */
    private String htmlUrl;

    /**
     * 证书描述信息
     */
    private String description;

    /**
     * 贡献者用户名
     */
    private String contributorName;

    /**
     * 二维码路径
     */
    private String qrCodeImagePath;


}
