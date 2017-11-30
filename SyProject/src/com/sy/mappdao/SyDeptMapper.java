package com.sy.mappdao;

import com.sy.entity.SyDept;
import com.sy.entity.SyDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyDeptMapper {
    int countByExample(SyDeptExample example);

    int deleteByExample(SyDeptExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(SyDept record);

    int insertSelective(SyDept record);

    List<SyDept> selectByExample(SyDeptExample example);

    SyDept selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") SyDept record, @Param("example") SyDeptExample example);

    int updateByExample(@Param("record") SyDept record, @Param("example") SyDeptExample example);

    int updateByPrimaryKeySelective(SyDept record);

    int updateByPrimaryKey(SyDept record);
}