package com.sy.mappdao;

import com.sy.entity.SyMeterType;
import com.sy.entity.SyMeterTypeExample;
import com.sy.entity.UsMeter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SyMeterTypeMapper {
	int countByExample(SyMeterTypeExample example);

	int deleteByExample(SyMeterTypeExample example);

	int deleteByPrimaryKey(Integer metertypeId);

	int insert(SyMeterType record);

	int insertSelective(SyMeterType record);

	List<SyMeterType> selectByExample(SyMeterTypeExample example);

	SyMeterType selectByPrimaryKey(Integer metertypeId);

	int updateByExampleSelective(@Param("record") SyMeterType record,
			@Param("example") SyMeterTypeExample example);

	int updateByExample(@Param("record") SyMeterType record,
			@Param("example") SyMeterTypeExample example);

	int updateByPrimaryKeySelective(SyMeterType record);

	int updateByPrimaryKey(SyMeterType record);

	// @author 卿建锋 绑定所有水表类型 查询水表所有类型
	List<SyMeterType> querySyMeterTypeAll();

	int updateSyMeterType(UsMeter meter);

	List<SyMeterType> selectAll();

}