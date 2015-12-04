package com.sy.projectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sy.entity.UsUser;

import javafx.util.converter.DateStringConverter;

/**
 * 收费管理帮助类
 * @author BarryLiu
 *
 */
public class SfglUtils {

	/**
	 * 得到当前时间开始月份对前推
	 * @param j 几个月正数
	 * @return
	 */
	public static List<String> getDateMonths(int j){
		List<String> dates=new ArrayList<String>();
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMM");
		for (int i = 0; i > -j; i--) {
			date=new Date();
			date.setMonth(date.getMonth()+i);
			String str = sdf.format(date);
			dates.add(str);
		}
		return dates;
	}

	/**传入对象 生成他的模糊查询的语句*/
	public static String getSqlWhereByUsUser(UsUser user) {
		if(user==null)return null;
		
		StringBuffer sb=new StringBuffer();
		if (user.getUserNo() != null && !"".equals(user.getUserNo().trim()))
			sb.append(" and user_no like '%"+user.getUserNo()+"%'");
		if (user.getAbc() != null && !"".equals(user.getAbc().trim()))
			sb.append(" and abc like '%"+user.getAbc()+"%'");
		if (user.getPhone() != null && !"".equals(user.getPhone().trim()))
			sb.append(" and phone like '%"+user.getPhone()+"%'");
		if (user.getSmsPhone() != null && !"".equals(user.getSmsPhone().trim()))
			sb.append(" and sms_phone like '%"+user.getSmsPhone()+"%'");
		if (user.getDocNum() != null && !"".equals(user.getDocNum().trim()))
			sb.append(" and doc_num like '%"+user.getDocNum()+"%'");
		if (user.getUserName() != null && !"".equals(user.getUserName().trim()))
			sb.append(" and user_name like '%"+user.getUserName()+"%'");
		if (user.getAddress() != null && !"".equals(user.getAddress().trim()))
			sb.append(" and address like '%"+user.getAddress()+"%'");
		return sb.toString();
	}
}
