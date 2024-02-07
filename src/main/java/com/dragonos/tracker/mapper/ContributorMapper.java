package com.dragonos.tracker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragonos.tracker.config.PageParams;
import com.dragonos.tracker.pojo.Contributor;

import java.util.List;

/**
 * <p>
 * 个人贡献表 Mapper 接口
 * </p>
 *
 * @author yummy
 */
public interface ContributorMapper extends BaseMapper<Contributor> {
    int clearTable();
    List<Contributor> selectAllByAllProject(PageParams pageParams);
}
