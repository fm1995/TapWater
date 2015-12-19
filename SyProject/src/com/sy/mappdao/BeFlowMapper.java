package com.sy.mappdao;

import com.sy.entity.BeFlow;
import com.sy.entity.BeFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeFlowMapper {
    int countByExample(BeFlowExample example);

    int deleteByExample(BeFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeFlow record);

    int insertSelective(BeFlow record);

    List<BeFlow> selectByExample(BeFlowExample example);

    BeFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeFlow record, @Param("example") BeFlowExample example);

    int updateByExample(@Param("record") BeFlow record, @Param("example") BeFlowExample example);

    int updateByPrimaryKeySelective(BeFlow record);

    int updateByPrimaryKey(BeFlow record);
}