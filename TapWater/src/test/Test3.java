package test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
	public static void main(String[] args) throws ParseException {
		String string="201507";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		System.out.println(new SimpleDateFormat("YYYYÄêMMÔÂ").format(sdf.parse(string))+"  "+string);
		
		DecimalFormat df1 = new DecimalFormat("0.0%");
		
		System.out.println(df1.format(0.22));
	}
}
