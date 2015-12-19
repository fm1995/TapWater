package com.sy.mappdao;

import com.sy.entity.RdChangevalue;
import com.sy.entity.RdChangevalueExample;
import com.sy.projectUtils.rd.TermUtil;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdChangevalueMapper {
    int countByExample(RdChangevalueExample example);

    int deleteByExample(RdChangevalueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RdChangevalue record);

    int insertSelective(RdChangevalue record);

    List<RdChangevalue> selectByExample(RdChangevalueExample example);

    RdChangevalue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RdChangevalue record, @Param("example") RdChangevalueExample example);

    int updateByExample(@Param("record") RdChangevalue record, @Param("example") RdChangevalueExample example);

    int updateByPrimaryKeySelective(RdChangevalue record);

    int updateByPrimaryKey(RdChangevalue record);
    
    List<RdChangevalue> selByTerm(@Param("term")TermUtil term, @Param("chang")RdChangevalue chang);

	int selByTermCount(@Param("term")TermUtil term, @Param("chang")RdChangevalue chang);
}