package com.sy.mappdao;

import com.sy.entity.UsMeter;
import com.sy.entity.UsMeterExample;
//import com.sy.projectUtils.TerUtil;

import com.sy.projectUtils.TerUtil;

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

	int updateByExampleSelective(@Param("record") UsMeter record,
			@Param("example") UsMeterExample example);

	int updateByExample(@Param("record") UsMeter record,
			@Param("example") UsMeterExample example);

	int updateByPrimaryKeySelective(UsMeter record);

	int updateByPrimaryKey(UsMeter record);

	List<UsMeter> selToReportMeterCheck(@Param("tu") TerUtil tu);

	int selCount(@Param("tu") TerUtil tu);

	/**
	 * �佨��
	 * */
	// ����ˮ��
	int cancellationUsMater(String userNo);
    
    //��ݻ���
    int updateMeterByUser(UsMeter meter);
}