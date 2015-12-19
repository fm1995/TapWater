package com.sy.service.sy;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sy.entity.SyCostType;
@Service
public class SyCostTypeService extends SyParent{
	/**
	 * ��ѯˮ����
	 */
	public List<SyCostType> queryCost()
	{
		return syCostTypeMapper.selectDisabled(null);
	}
	/**
	 * ���ˮ����
	 * @param sy
	 */
	public void saveCost(SyCostType sy) {
		syCostTypeMapper.insert(sy);
	}
	/**
	 * ��ѯ����ˮ����
	 */
	public SyCostType queryOneCost(int id)
	{
		return syCostTypeMapper.selectByPrimaryKey(id);
	}
	/**
	 * �޸ĵ���ˮ����
	 */
	public void updateCost(SyCostType sy)
	{
		syCostTypeMapper.updateByPrimaryKey(sy);
	}
	/**
	 * �޸Ľ�ֹˮ����
	 */
	public void updateCostDisabled(int id)
	{
		syCostTypeMapper.updateCostDisabled(id);
	}
//	------------
	/**
	 * ��ѯ���ӷ�����
	 */
	public List<SyCostType> querySurcharge()
	{
		return syCostTypeMapper.selectSurcharge(null);
	}

	/**
	 * �޸Ľ�ֹ���ӷ�����
	 */
	public void updateSurchargeDisabled(int id)
	{
		syCostTypeMapper.updateCostDisabled(id);
	}
	/**
	 * ��ѯ����id
	 * @return
	 */
	public int selectMax()
	{
		return syCostTypeMapper.selectMax();
	}
	
}