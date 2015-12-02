package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
	public static void main(String[] args) {
		
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMM");
		for (int i = 0; i > -8; i--) {
			date=new Date();
			date.setMonth(date.getMonth()+i);
			String str = sdf.format(date);
			int month = date.getMonth();
			System.out.println(str);
		}
		
		System.out.println(new Date().getMonth());
	}
}
