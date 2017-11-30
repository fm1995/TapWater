package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyDept;

@Service
public class SyDeptService extends SyParent{
	/**
	   * ��Ӳ���
	   * @param sy
	   */
		public void saveDept(SyDept sy)
		{
		  syDeptMapper.insert(sy);
		}
		/**
		 * ��ѯȫ������
		 * @return
		 */
		public List<SyDept> queryDept()
		{	
			return syDeptMapper.selectByExample(null);
		}
		/**
		 * ɾ������
		 */
		public void deleteDept(int id)
		{
			syDeptMapper.deleteByPrimaryKey(id);
		}
		/**
		 * ����������ѯ��������
		 * @param id
		 * @return
		 */
		public SyDept queryOneDept(int id)
		{
			return syDeptMapper.selectByPrimaryKey(id);
		}
		/**
		 * �޸Ĳ���
		 */
		public void updateDept(SyDept sy)
		{
			syDeptMapper.updateByPrimaryKey(sy);
		}
		
}