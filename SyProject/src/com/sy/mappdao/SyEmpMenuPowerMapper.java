package com.sy.mappdao;

import com.sy.entity.SyEmpMenuPower;
import com.sy.entity.SyEmpMenuPowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyEmpMenuPowerMapper {
    int countByExample(SyEmpMenuPowerExample example);

    int deleteByExample(SyEmpMenuPowerExample example);

    int deleteByPrimaryKey(Integer empmenupowerId);

    int insert(SyEmpMenuPower record);

    int insertSelective(SyEmpMenuPower record);

    List<SyEmpMenuPower> selectByExample(SyEmpMenuPowerExample example);

    SyEmpMenuPower selectByPrimaryKey(Integer empmenupowerId);

    int updateByExampleSelective(@Param("record") SyEmpMenuPower record, @Param("example") SyEmpMenuPowerExample example);

    int updateByExample(@Param("record") SyEmpMenuPower record, @Param("example") SyEmpMenuPowerExample example);

    int updateByPrimaryKeySelective(SyEmpMenuPower record);

    int updateByPrimaryKey(SyEmpMenuPower record);
    
    List<SyEmpMenuPower> selectMenu(int id);
}