package com.sy.projectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.util.converter.DateStringConverter;

/**
 * �շѹ��������
 * @author BarryLiu
 *
 */
public class SfglUtils {

	/**
	 * �õ���ǰʱ�俪ʼ�·ݶ�ǰ��
	 * @param j ����������
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
}
