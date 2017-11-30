package com.sy.service.sy;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyCostType;
@Service
public class SyCostTypeService extends SyParent{
	/**
	 * 查询水类型
	 */
	public List<SyCostType> queryCost()
	{
		return syCostTypeMapper.selectDisabled(null);
	}
	/**
	 * 添加水类型
	 * @param sy
	 */
	public void saveCost(SyCostType sy) {
		syCostTypeMapper.insert(sy);
	}
	/**
	 * 查询单个水类型
	 */
	public SyCostType queryOneCost(int id)
	{
		return syCostTypeMapper.selectByPrimaryKey(id);
	}
	/**
	 * 修改单个水类型
	 */
	public void updateCost(SyCostType sy)
	{
		syCostTypeMapper.updateByPrimaryKey(sy);
	}
	/**
	 * 修改禁止水类型
	 */
	public void updateCostDisabled(int id)
	{
		syCostTypeMapper.updateCostDisabled(id);
	}
//	------------
	/**
	 * 查询附加费类型
	 */
	public List<SyCostType> querySurcharge()
	{
		return syCostTypeMapper.selectSurcharge(null);
	}

	/**
	 * 修改禁止附加费类型
	 */
	public void updateSurchargeDisabled(int id)
	{
		syCostTypeMapper.updateCostDisabled(id);
	}
	/**
	 * 查询最大的id
	 * @return
	 */
	public int selectMax()
	{
		return syCostTypeMapper.selectMax();
	}
	
}