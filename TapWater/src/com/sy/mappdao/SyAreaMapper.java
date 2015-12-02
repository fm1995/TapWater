package com.sy.mappdao;

import com.sy.entity.SyArea;
import com.sy.entity.SyAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyAreaMapper {
    int countByExample(SyAreaExample example);

    int deleteByExample(SyAreaExample example);

    int deleteByPrimaryKey(Integer areaId);

    int insert(SyArea record);

    int insertSelective(SyArea record);

    List<SyArea> selectByExample(SyAreaExample example);

    SyArea selectByPrimaryKey(Integer areaId);

    int updateByExampleSelective(@Param("record") SyArea record, @Param("example") SyAreaExample example);

    int updateByExample(@Param("record") SyArea record, @Param("example") SyAreaExample example);

    int updateByPrimaryKeySelective(SyArea record);

    int updateByPrimaryKey(SyArea record);
}