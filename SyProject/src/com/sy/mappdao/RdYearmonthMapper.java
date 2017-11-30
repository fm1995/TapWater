package com.sy.mappdao;

import com.sy.entity.RdYearmonth;
import com.sy.entity.RdYearmonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdYearmonthMapper {
    int countByExample(RdYearmonthExample example);

    int deleteByExample(RdYearmonthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdYearmonth record);

    int insertSelective(RdYearmonth record);

    List<RdYearmonth> selectByExample(RdYearmonthExample example);

    RdYearmonth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdYearmonth record, @Param("example") RdYearmonthExample example);

    int updateByExample(@Param("record") RdYearmonth record, @Param("example") RdYearmonthExample example);

    int updateByPrimaryKeySelective(RdYearmonth record);

    int updateByPrimaryKey(RdYearmonth record);

	List<RdYearmonth> selAll();

	List<RdYearmonth> selAllAndEmp();

	int isInit();

	void upIsCurrent();

}