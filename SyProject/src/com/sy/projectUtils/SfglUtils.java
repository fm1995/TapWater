package com.sy.projectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sy.entity.PyBill;
import com.sy.entity.PyBillExample;
import com.sy.entity.UsUser;
import com.sy.entity.PyBillExample.Criteria;
import com.sy.mappdao.PyBillMapper;
import com.sy.mappdao.UsUserMapper;

/**
 * 收费管理帮助类
 * 
 * @author BarryLiu
 *
 */
public class SfglUtils {

	/**
	 * 得到当前时间开始月份对前推
	 * 
	 * @param j
	 *            几个月正数
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getDateMonths(int j) {
		List<String> dates = new ArrayList<String>();
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMM");
		for (int i = 0; i > -j; i--) {
			date = new Date();
			date.setMonth(date.getMonth() + i);
			String str = sdf.format(date);
			dates.add(str);
		}
		return dates;
	}

	/** 传入对象 生成他的模糊查询的语句 */
	public static String getSqlWhereByUsUser(UsUser user) {
		if (user == null)
			return null;

		StringBuffer sb = new StringBuffer();
		if (user.getUserNo() != null && !"".equals(user.getUserNo().trim()))
			sb.append(" and user_no like '%" + user.getUserNo() + "%'");
		if (user.getAbc() != null && !"".equals(user.getAbc().trim()))
			sb.append(" and abc like '%" + user.getAbc() + "%'");
		if (user.getPhone() != null && !"".equals(user.getPhone().trim()))
			sb.append(" and phone like '%" + user.getPhone() + "%'");
		if (user.getSmsPhone() != null && !"".equals(user.getSmsPhone().trim()))
			sb.append(" and sms_phone like '%" + user.getSmsPhone() + "%'");
		if (user.getDocNum() != null && !"".equals(user.getDocNum().trim()))
			sb.append(" and doc_num like '%" + user.getDocNum() + "%'");
		if (user.getUserName() != null && !"".equals(user.getUserName().trim()))
			sb.append(" and user_name like '%" + user.getUserName() + "%'");
		if (user.getAddress() != null && !"".equals(user.getAddress().trim()))
			sb.append(" and address like '%" + user.getAddress() + "%'");
		return sb.toString();
	}

	/**
	 * 将传进来的 abc,def,efg, 格式的字符串转换成数组返回
	 * @param unos
	 * @return
	 */
	public static String[] toConvertString(String string) {
		if (string==null) 
			return new String[0];
		string=string.substring(0, string.length()-1);//去掉最后的以一个空格
		String[] split = string.split(",");
		return split;
	}
	
	/**
	 * 转换 提笔提量    
	 * @param formula 提笔提量公式
	 * @return  拆分好的值
	 */
	public static String[] toSplit(String formula) {
		String[] split = formula.split("]");
		String[] mula =new String[split.length];
		 for (int i = 0; i < split.length; i++) {
			 String str=split[i].substring(1,split[i].length());
			 mula[i]=str;
		}
		return mula;
	}
	/**
	 * 根据传进来的参数转换成 查询语句的 收费情况报表where条件
	 * @param dto
	 * @return
	 */
	public static String converPayWhere(SfglDto dto) {
		if(dto==null)
			return null;
		StringBuffer sb=new StringBuffer();
		if(dto.getUserNo()!=null && !"".equals(dto.getUserNo()))
			sb.append(" and pay.user_no like '%"+dto.getUserNo()+"%'");
		if(dto.getEmpId()!=null && !"".equals(dto.getEmpId()))
			sb.append(" and pay.emp_id = "+dto.getEmpId());
		if(dto.getPayDateBefore()!=null && !"".equals(dto.getPayDateBefore()))
			sb.append(" and pay.pay_date >"+dto.getPayDateBefore());
		if(dto.getPayDateAfter()!=null && !"".equals(dto.getPayDateAfter()))
			sb.append(" and pay.pay_date <"+dto.getPayDateAfter());
		
		if(dto.getIvNoBefore()!=null && !"".equals(dto.getIvNoBefore()))
			sb.append(" and pay.invoice >"+dto.getIvNoBefore());
		if(dto.getIvNoAfter()!=null && !"".equals(dto.getIvNoAfter()))
			sb.append(" and pay.invoice <"+dto.getIvNoAfter());
		return sb.toString().trim();
	}
	/**
	 * 根据 参数算出 欠费报表的查询条件
	 * @param dto
	 * @return
	 */
	public static String convertBillWhere(SfglDto dto) {
		if(dto==null)
			return null;
		StringBuffer sb=new StringBuffer("");
		
		if(dto.getPayDateBefore()!=null&&!"".equals(dto.getPayDateBefore()))
			sb.append(" and py.create_date > str_to_date('"+dto.getPayDateBefore()+"','%Y%m')");
		if(dto.getPayDateAfter()!=null&&!"".equals(dto.getPayDateAfter()))
			sb.append(" and py.create_date < str_to_date('"+dto.getPayDateAfter()+"','%Y%m')");
		if(dto.getVolume()!=null){
			String volumes=Arrays.toString(dto.getVolume()).substring(1, Arrays.toString(dto.getVolume()).length()-1);
			sb.append(" and  us.area_id in ("+volumes+")");
		}
		if(dto.getOrderStr()!=null)
			sb.append(" order by py."+dto.getOrderStr());
		return sb.toString();
	}

	/**
	 * 根据用户的编号查询出他所有的没结清的水费单
	 * @param pyBillMapper
	 * @param userNo
	 * @return 所有欠费的水费单
	 */
	public static List<PyBill> selPyBills(PyBillMapper pyBillMapper,String  userNo) {
		PyBillExample example = new PyBillExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNoEqualTo(userNo);
		criteria.andBalanceEqualTo(false);
		List<PyBill> pyBills = pyBillMapper.selectByExample(example);
		return pyBills;
	}
}
