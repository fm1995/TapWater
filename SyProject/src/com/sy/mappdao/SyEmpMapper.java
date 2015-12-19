package com.sy.mappdao;

import com.sy.entity.SyEmp;
import com.sy.entity.SyEmpExample;
import com.sy.integration.iv.EmpReturnClass;

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

//    鑷畾涔�

//   �Զ���

    List<SyEmp> selectAll();
    List<SyEmp> selectSyEmp(int id);
    SyEmp selectLogin(@Param("empNo") String empNo,@Param("empPwd") String empPwd);
    

   /****************************************
    * 
    * @author 卿建锋 
    * 
    * 定义SQL
    */
   
	int queryEmpIDByName(String empName);
	List<SyEmp> queryEmpAll();
	String queryEmpNameById(Integer empId);
	/***************************************/
    List<SyEmp> selEmpByDeptId(int deptId);
    
    //��ѯemp����id,name�����ֶ�
    List<SyEmp> selIvEmp();
    
    
    
    /*
	 * 发票管理
	 * 收票人员查询
	 * */
	List<EmpReturnClass> selEmpIvCount(int page);

	/*
	 * 发票管理
	 * 收票人员总条数查询
	 * */
	Integer selEmpIvAllCount();

}