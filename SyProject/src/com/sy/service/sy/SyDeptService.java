package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyDept;

@Service
public class SyDeptService extends SyParent{
	/**
	   * 添加部门
	   * @param sy
	   */
		public void saveDept(SyDept sy)
		{
		  syDeptMapper.insert(sy);
		}
		/**
		 * 查询全部部门
		 * @return
		 */
		public List<SyDept> queryDept()
		{	
			return syDeptMapper.selectByExample(null);
		}
		/**
		 * 删除部门
		 */
		public void deleteDept(int id)
		{
			syDeptMapper.deleteByPrimaryKey(id);
		}
		/**
		 * 根据主键查询部门详情
		 * @param id
		 * @return
		 */
		public SyDept queryOneDept(int id)
		{
			return syDeptMapper.selectByPrimaryKey(id);
		}
		/**
		 * 修改部门
		 */
		public void updateDept(SyDept sy)
		{
			syDeptMapper.updateByPrimaryKey(sy);
		}
		
}