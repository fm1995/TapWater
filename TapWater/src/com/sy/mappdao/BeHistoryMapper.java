package com.sy.mappdao;

import com.sy.entity.BeHistory;
import com.sy.entity.BeHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeHistoryMapper {
    int countByExample(BeHistoryExample example);

    int deleteByExample(BeHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeHistory record);

    int insertSelective(BeHistory record);

    List<BeHistory> selectByExample(BeHistoryExample example);

    BeHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeHistory record, @Param("example") BeHistoryExample example);

    int updateByExample(@Param("record") BeHistory record, @Param("example") BeHistoryExample example);

    int updateByPrimaryKeySelective(BeHistory record);

    int updateByPrimaryKey(BeHistory record);
}