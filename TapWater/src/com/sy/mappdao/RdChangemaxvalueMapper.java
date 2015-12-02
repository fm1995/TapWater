package com.sy.mappdao;

import com.sy.entity.RdChangemaxvalue;
import com.sy.entity.RdChangemaxvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdChangemaxvalueMapper {
    int countByExample(RdChangemaxvalueExample example);

    int deleteByExample(RdChangemaxvalueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdChangemaxvalue record);

    int insertSelective(RdChangemaxvalue record);

    List<RdChangemaxvalue> selectByExample(RdChangemaxvalueExample example);

    RdChangemaxvalue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdChangemaxvalue record, @Param("example") RdChangemaxvalueExample example);

    int updateByExample(@Param("record") RdChangemaxvalue record, @Param("example") RdChangemaxvalueExample example);

    int updateByPrimaryKeySelective(RdChangemaxvalue record);

    int updateByPrimaryKey(RdChangemaxvalue record);
}