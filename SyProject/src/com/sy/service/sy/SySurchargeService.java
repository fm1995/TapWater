package com.sy.service.sy;

import org.springframework.stereotype.Service;

import com.sy.entity.SySurcharge;
import com.sy.entity.SySurchargeExample;
import com.sy.mappdao.SySurchargeMapper;

@Service
public class SySurchargeService extends SyParent{
	/**
	 * 添加附加费与水类型的关系
	 * @param sy
	 */
	public void saveSucharge(SySurcharge sy)
	{
		sySurchargeMapper.insert(sy);
	}
	/**
	 * 得到附加费的ID修改附加费与水类型的关系
	 */
	public void deleteSucharge(int id)
	{	
	    SySurchargeExample example=new SySurchargeExample();
	    example.createCriteria().andSurchargeIdEqualTo(id);
		sySurchargeMapper.deleteByExample(example);
	}
}