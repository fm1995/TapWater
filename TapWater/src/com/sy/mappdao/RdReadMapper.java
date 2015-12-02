package com.sy.mappdao;

import com.sy.entity.RdRead;
import com.sy.entity.RdReadExample;
import com.sy.entity.ReadView;
import com.sy.projectUtils.cbgl.TermUtil;

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


	List<ReadView> selByYearAndMonth(RdRead read);

	List<RdRead> selReadByTerm(@Param("term")TermUtil term, @Param("read")RdRead read);
}