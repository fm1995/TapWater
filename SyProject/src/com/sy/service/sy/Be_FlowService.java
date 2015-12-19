package com.sy.service.sy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.BeFlow;
import com.sy.entity.SyDept;
import com.sy.mappdao.SyDeptMapper;
@Service
public class Be_FlowService extends SyParent{
   /**
    * 查询全部流程
    */
	public List<BeFlow> queryFlow()
	{
		
		return beFlowMapper.selectByExample(null);
	}
	/**
	 * 查询�?有的部门
	 */
	public List<SyDept> queryDept()
	{
		return syDeptMapper.selectByExample(null);
	}
	/**
	 * 修改部门�?在流程模�?
	 * @param be
	 */
	public void updateFlow(BeFlow be)
	{
		beFlowMapper.updateByPrimaryKeySelective(be);
	}
}
