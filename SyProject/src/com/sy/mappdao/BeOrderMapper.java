package com.sy.mappdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.entity.BeOrder;
import com.sy.entity.BeOrderExample;
import com.sy.entity.BeOrderTable;

public interface BeOrderMapper {
	int countByExample(BeOrderExample example);

	int deleteByExample(BeOrderExample example);

	int deleteByPrimaryKey(String orderNo);

	int insert(BeOrder record);

	int insertSelective(BeOrder record);

	List<BeOrder> selectByExample(BeOrderExample example);

	BeOrder selectByPrimaryKey(String orderNo);

	int updateByExampleSelective(@Param("record") BeOrder record,
			@Param("example") BeOrderExample example);

	int updateByExample(@Param("record") BeOrder record,
			@Param("example") BeOrderExample example);

	int updateByPrimaryKeySelective(BeOrder record);

	int updateByPrimaryKey(BeOrder record);

	// ��ҳ��ʾ�Ĵ��?�� use_target�ʹ����洦���Ĺ�������,phone�������մ���õĲ���
	List<BeOrder> waitBe();

	List<BeOrder> selByStep(@Param("stepId") int stepId,
			@Param("start") int page);

	int selByCount1(int stepId);

	BeOrder selectByOrderNo(String orderNo);

	BeOrder queryByOrdeNo(@Param("be") String be);

	List<BeOrder> selByRe(@Param("stepId") int stepId,
			@Param("orderType") int orderType,
			@Param("orderNo") String orderNo,
			@Param("userName") String userName, @Param("start") int page);

	int selByCount3(@Param("stepId") int stepId,
			@Param("orderType") int orderType,
			@Param("orderNo") String orderNo, @Param("userName") String userName);

	List<BeOrderTable> selGroup(int stepId);

	int selGroupCount(int stepId);
	
	BeOrder selMaxNo(@Param("type") String type);

}