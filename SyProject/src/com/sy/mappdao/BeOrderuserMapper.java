package com.sy.mappdao;

import com.sy.entity.BeOrderuser;
import com.sy.entity.BeOrderuserExample;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BeOrderuserMapper {
	int countByExample(BeOrderuserExample example);

	int deleteByExample(BeOrderuserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BeOrderuser record);

	int insertSelective(BeOrderuser record);

	List<BeOrderuser> selectByExample(BeOrderuserExample example);

	BeOrderuser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BeOrderuser record,
			@Param("example") BeOrderuserExample example);

	int updateByExample(@Param("record") BeOrderuser record,
			@Param("example") BeOrderuserExample example);

	int updateByPrimaryKeySelective(BeOrderuser record);

	int updateByPrimaryKey(BeOrderuser record);

	// 通过OrderNO查询用户表单详情
	List<BeOrderuser> queryByOrdeNo(@Param("be") String be);

	List<BeOrderuser> selectByOrderNo(String orderNo);

	List<BeOrderuser> selectByOrderNo2(String orderNo);
	
	List<BeOrderuser> selAllOrderuser(@Param("orderType1") String orderType1,
			@Param("orderType2") String orderType2,
			@Param("orderType3") String orderType3, @Param("date1") Date date1,
			@Param("date2") Date date2, @Param("start") int start);

	int selAllOrderuserCount(@Param("orderType1") String orderType1,
			@Param("orderType2") String orderType2,
			@Param("orderType3") String orderType3, @Param("date1") Date date1,
			@Param("date2") Date date2);


	int newUserCount();

	 Integer selAllOrderuserMoney(@Param("orderType1") String orderType1,
			@Param("orderType2") String orderType2,
			@Param("orderType3") String orderType3, @Param("date1") Date date1,
			@Param("date2") Date date2);
}