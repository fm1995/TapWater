package com.sy.service.sfgl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sy.entity.SyCostType;
import com.sy.projectUtils.SfglUtils;
import com.sy.service.parentser.ParentSerI;
import com.sy.service.parentser.PyParentSer;

@Service
public class SYCostTypeService extends PyParentSer implements ParentSerI<SyCostType>{

	@Override
	public List<SyCostType> getAll() {
		return syCostTypeMapper.selectByExample(null);
	}

	@Override
	public SyCostType selectByPrimaryKey(String id) {
		return syCostTypeMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public int insert(SyCostType entity) {
		return syCostTypeMapper.insert(entity);
	}

	@Override
	public int update(SyCostType entity) {
		return syCostTypeMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int delete(String id) {
		return syCostTypeMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

	
	
	//================������ˮͳ���ܱ�  
	public Map<String, Object> tongji() {
		Map<String, Object> map = new HashMap<String, Object>();
		 map.put("months",  SfglUtils.getDateMonths(12));
		 map.put("types", getAll());
		 
		 return map;
	}

	/**���ʽ�����������
	 * @throws ParseException */
	public Map<String, Object> monthRecycle(String ymonth) throws ParseException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMM");
		if(ymonth==null)
			ymonth=sdf.format(new Date());
		Date date = sdf.parse(ymonth);
		
		
		
		
		//rdReadMapper.selectAmountsByYearAndMonth(date.getYear(),date.getMonth()+1);
		//�ܶ�λ
		Integer amounts = rdReadMapper.selectAmountsByYearAndMonth(ymonth);
//		int amounts=2222;
		//��Ӧ��
		Double billMoneys=pyBillMapper.selectBillMoneysByCreateTime(ymonth);
		//��ʵ��
		Double realMoneys=pyBillMapper.selectRealMoneysByCreateTime(ymonth);
		//�´�
		amounts = amounts!=null?amounts:0;
		billMoneys = billMoneys!=null?billMoneys:0;
		realMoneys = realMoneys!=null?realMoneys:0;
		Double  nextMoneys=billMoneys-realMoneys;
		//������
		
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("months", SfglUtils.getDateMonths(6));
		map.put("month",  new SimpleDateFormat("YYYY��MM��").format(date));
		map.put("mth",  ymonth);
		map.put("amounts", amounts);
		map.put("billMoneys", billMoneys);
		map.put("realMoneys", realMoneys);
		map.put("nextMoneys", nextMoneys);
		
		return map;
	}

}
