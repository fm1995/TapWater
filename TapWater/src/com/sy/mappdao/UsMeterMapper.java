package com.sy.mappdao;

import com.sy.entity.UsMeter;
import com.sy.entity.UsMeterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsMeterMapper {
    int countByExample(UsMeterExample example);

    int deleteByExample(UsMeterExample example);

    int deleteByPrimaryKey(String meterNo);

    int insert(UsMeter record);

    int insertSelective(UsMeter record);

    List<UsMeter> selectByExample(UsMeterExample example);

    UsMeter selectByPrimaryKey(String meterNo);

    int updateByExampleSelective(@Param("record") UsMeter record, @Param("example") UsMeterExample example);

    int updateByExample(@Param("record") UsMeter record, @Param("example") UsMeterExample example);

    int updateByPrimaryKeySelective(UsMeter record);

    int updateByPrimaryKey(UsMeter record);
}