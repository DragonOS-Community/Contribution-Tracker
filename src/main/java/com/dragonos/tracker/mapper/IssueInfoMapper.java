package com.dragonos.tracker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragonos.tracker.pojo.IssueInfo;
/**
 * <p>
 * issue信息表 Mapper 接口
 * </p>
 *
 * @author yummy
 */
public interface IssueInfoMapper extends BaseMapper<IssueInfo> {
    int clearTable();
}
