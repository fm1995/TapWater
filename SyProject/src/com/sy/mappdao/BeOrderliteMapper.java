package com.sy.mappdao;

import com.sy.entity.BeOrderlite;
import com.sy.entity.BeOrderliteExample;
import com.sy.entity.userhelp.OrderLite;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BeOrderliteMapper {
    int countByExample(BeOrderliteExample example);

    int deleteByExample(BeOrderliteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeOrderlite record);

    int insertSelective(BeOrderlite record);

    List<BeOrderlite> selectByExample(BeOrderliteExample example);

    BeOrderlite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeOrderlite record, @Param("example") BeOrderliteExample example);

    int updateByExample(@Param("record") BeOrderlite record, @Param("example") BeOrderliteExample example);

    int updateByPrimaryKeySelective(BeOrderlite record);

    int updateByPrimaryKey(BeOrderlite record);
    
    /* ***********************@author 卿建锋      快捷操作记录查询*************************** */
    List<BeOrderlite>queryEmpsByParemter(OrderLite orderLite);
    
    int queryOrderLiteCount(OrderLite orderLite);
}