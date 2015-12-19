package com.sy.service.py;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sy.entity.SyCostType;
import com.sy.projectUtils.SfglUtils;

@Service
public class PySYCostTypeService extends PyParent implements ParentSerI<SyCostType>{

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

	

	/**���ʽ�����������
	 * @throws ParseException */
	public Map<String, Object> monthRecycle(String ymonth) throws ParseException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		if(ymonth==null)
			ymonth=sdf.format(new Date());
		 
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
		DecimalFormat df1 = new DecimalFormat("0.0%");
		Double back=realMoneys/billMoneys;
		String backResult=df1.format(back.isNaN()?0.0:back);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("months", SfglUtils.getDateMonths(6));
		map.put("selmonth",  new SimpleDateFormat("yyyy��MM��").format(sdf.parse(ymonth)));
		map.put("mth",  ymonth);
		map.put("amounts", amounts);
		map.put("billMoneys", billMoneys);
		map.put("realMoneys", realMoneys);
		map.put("nextMoneys", nextMoneys);
		map.put("backResult", backResult);
		
		return map;
	}

	
	
}
