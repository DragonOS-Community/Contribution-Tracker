package com.dragonos.tracker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragonos.tracker.pojo.PrInfo;

/**
 * <p>
 * pr信息表 Mapper 接口
 * </p>
 *
 * @author yummy
 */
public interface PrInfoMapper extends BaseMapper<PrInfo> {
    int clearTable();
}
