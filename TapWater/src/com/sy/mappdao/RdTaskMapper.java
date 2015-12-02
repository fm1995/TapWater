package com.sy.mappdao;

import com.sy.entity.RdTask;
import com.sy.entity.RdTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdTaskMapper {
    int countByExample(RdTaskExample example);

    int deleteByExample(RdTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdTask record);

    int insertSelective(RdTask record);

    List<RdTask> selectByExample(RdTaskExample example);

    RdTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdTask record, @Param("example") RdTaskExample example);

    int updateByExample(@Param("record") RdTask record, @Param("example") RdTaskExample example);

    int updateByPrimaryKeySelective(RdTask record);

    int updateByPrimaryKey(RdTask record);
}