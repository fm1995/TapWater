package com.sy.mappdao;

import com.sy.entity.RdRead;
import com.sy.entity.RdReadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdReadMapper {
    int countByExample(RdReadExample example);

    int deleteByExample(RdReadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdRead record);

    int insertSelective(RdRead record);

    List<RdRead> selectByExample(RdReadExample example);

    RdRead selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdRead record, @Param("example") RdReadExample example);

    int updateByExample(@Param("record") RdRead record, @Param("example") RdReadExample example);

    int updateByPrimaryKeySelective(RdRead record);

    int updateByPrimaryKey(RdRead record);

    
    //自定义查询语句BarryLiu 
    /**查询*/
	Integer selectAmountsByYearAndMonth(@Param("ymonth")String ymonth);
}