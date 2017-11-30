package com.sy.service.sy;

import org.springframework.stereotype.Service;

import com.sy.entity.SySurcharge;
import com.sy.entity.SySurchargeExample;
import com.sy.mappdao.SySurchargeMapper;

@Service
public class SySurchargeService extends SyParent{
	/**
	 * ��Ӹ��ӷ���ˮ���͵Ĺ�ϵ
	 * @param sy
	 */
	public void saveSucharge(SySurcharge sy)
	{
		sySurchargeMapper.insert(sy);
	}
	/**
	 * �õ����ӷѵ�ID�޸ĸ��ӷ���ˮ���͵Ĺ�ϵ
	 */
	public void deleteSucharge(int id)
	{	
	    SySurchargeExample example=new SySurchargeExample();
	    example.createCriteria().andSurchargeIdEqualTo(id);
		sySurchargeMapper.deleteByExample(example);
	}
}