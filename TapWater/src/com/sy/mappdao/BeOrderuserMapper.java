package com.sy.mappdao;

import com.sy.entity.BeOrderuser;
import com.sy.entity.BeOrderuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeOrderuserMapper {
    int countByExample(BeOrderuserExample example);

    int deleteByExample(BeOrderuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeOrderuser record);

    int insertSelective(BeOrderuser record);

    List<BeOrderuser> selectByExample(BeOrderuserExample example);

    BeOrderuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeOrderuser record, @Param("example") BeOrderuserExample example);

    int updateByExample(@Param("record") BeOrderuser record, @Param("example") BeOrderuserExample example);

    int updateByPrimaryKeySelective(BeOrderuser record);

    int updateByPrimaryKey(BeOrderuser record);
}