package com.sy.mappdao;

import com.sy.entity.SySurcharge;
import com.sy.entity.SySurchargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SySurchargeMapper {
    int countByExample(SySurchargeExample example);

    int deleteByExample(SySurchargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SySurcharge record);

    int insertSelective(SySurcharge record);

    List<SySurcharge> selectByExample(SySurchargeExample example);

    SySurcharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SySurcharge record, @Param("example") SySurchargeExample example);

    int updateByExample(@Param("record") SySurcharge record, @Param("example") SySurchargeExample example);

    int updateByPrimaryKeySelective(SySurcharge record);

    int updateByPrimaryKey(SySurcharge record);
}