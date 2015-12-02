package com.sy.mappdao;

import com.sy.entity.BeOrder;
import com.sy.entity.BeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeOrderMapper {
    int countByExample(BeOrderExample example);

    int deleteByExample(BeOrderExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(BeOrder record);

    int insertSelective(BeOrder record);

    List<BeOrder> selectByExample(BeOrderExample example);

    BeOrder selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") BeOrder record, @Param("example") BeOrderExample example);

    int updateByExample(@Param("record") BeOrder record, @Param("example") BeOrderExample example);

    int updateByPrimaryKeySelective(BeOrder record);

    int updateByPrimaryKey(BeOrder record);
}