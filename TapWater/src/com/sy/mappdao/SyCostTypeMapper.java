package com.sy.mappdao;

import com.sy.entity.SyCostType;
import com.sy.entity.SyCostTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyCostTypeMapper {
    int countByExample(SyCostTypeExample example);

    int deleteByExample(SyCostTypeExample example);

    int deleteByPrimaryKey(Integer costtypeId);

    int insert(SyCostType record);

    int insertSelective(SyCostType record);

    List<SyCostType> selectByExample(SyCostTypeExample example);

    SyCostType selectByPrimaryKey(Integer costtypeId);

    int updateByExampleSelective(@Param("record") SyCostType record, @Param("example") SyCostTypeExample example);

    int updateByExample(@Param("record") SyCostType record, @Param("example") SyCostTypeExample example);

    int updateByPrimaryKeySelective(SyCostType record);

    int updateByPrimaryKey(SyCostType record);
}