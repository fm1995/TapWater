package com.sy.mappdao;

import com.sy.entity.SyEmpAreaPower;
import com.sy.entity.SyEmpAreaPowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyEmpAreaPowerMapper {
    int countByExample(SyEmpAreaPowerExample example);

    int deleteByExample(SyEmpAreaPowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SyEmpAreaPower record);

    int insertSelective(SyEmpAreaPower record);

    List<SyEmpAreaPower> selectByExample(SyEmpAreaPowerExample example);

    SyEmpAreaPower selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SyEmpAreaPower record, @Param("example") SyEmpAreaPowerExample example);

    int updateByExample(@Param("record") SyEmpAreaPower record, @Param("example") SyEmpAreaPowerExample example);

    int updateByPrimaryKeySelective(SyEmpAreaPower record);

    int updateByPrimaryKey(SyEmpAreaPower record);
}