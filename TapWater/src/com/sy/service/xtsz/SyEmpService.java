package com.sy.service.xtsz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyDept;
import com.sy.entity.SyEmp;
import com.sy.service.parentser.SyParentSer;

@Service
public class SyEmpService extends SyParentSer{
	/**
	 * 查询所有的部门表
	 */
	public List<SyDept> queryEmp() {
		return syDeptMapper.selectByExample(null);
	}

	/**
	 * 查询员工所有的 信息
	 * 
	 * @return
	 */
	public List<SyEmp> queryEmp_() {
		return syEmpMapper.selectAll();
	}

	/**
	 * 添加员工
	 */
	public void saveEmp(SyEmp sy) {
		syEmpMapper.insert(sy);
	}

	/**
	 * 删除员工
	 */
	public void deleteEmp(int id) {
		syEmpMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据ID查询单个信息
	 */
	public SyEmp queryOneEmp(int id) {
		return syEmpMapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改员工信息
	 */
	public void updateEmp(SyEmp sy) {
		syEmpMapper.updateByPrimaryKey(sy);
		
	}
	public void updateEmpLogin(SyEmp sy) {
		syEmpMapper.updateByPrimaryKeySelective(sy);
	}
	
	/**
	 * 得到部门的ID查询员工信息
	 * 
	 * @return
	 */
	public List<SyEmp> querySyEmp(int id) {
		return syEmpMapper.selectSyEmp(id);
	}

	// -----------------
	/**
	 * 登陆判断
	 */
	public SyEmp queryLogin(SyEmp sy) {
		return  syEmpMapper.selectLogin(sy.getEmpNo(),sy.getEmpPwd());
	}
}