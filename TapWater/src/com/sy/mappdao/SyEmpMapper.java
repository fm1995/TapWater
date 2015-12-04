package com.sy.mappdao;

import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyEmpMapper {
    int countByExample(SyEmpExample example);

    int deleteByExample(SyEmpExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(SyEmp record);

    int insertSelective(SyEmp record);

    List<SyEmp> selectByExample(SyEmpExample example);

    SyEmp selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") SyEmp record, @Param("example") SyEmpExample example);

    int updateByExample(@Param("record") SyEmp record, @Param("example") SyEmpExample example);

    int updateByPrimaryKeySelective(SyEmp record);

    int updateByPrimaryKey(SyEmp record);

	List<SyEmp> selEmpByDeptId(int deptId);
}