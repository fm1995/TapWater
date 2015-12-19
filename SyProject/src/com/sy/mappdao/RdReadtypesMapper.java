package com.sy.mappdao;

import com.sy.entity.PyBilldetail;
import com.sy.entity.RdReadtypes;
import com.sy.entity.RdReadtypesExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdReadtypesMapper {
    int countByExample(RdReadtypesExample example);

    int deleteByExample(RdReadtypesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdReadtypes record);

    int insertSelective(RdReadtypes record);

    List<RdReadtypes> selectByExample(RdReadtypesExample example);

    RdReadtypes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdReadtypes record, @Param("example") RdReadtypesExample example);

    int updateByExample(@Param("record") RdReadtypes record, @Param("example") RdReadtypesExample example);

    int updateByPrimaryKeySelective(RdReadtypes record);

    int updateByPrimaryKey(RdReadtypes record);

}