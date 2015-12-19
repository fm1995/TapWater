package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class Test2 {
	public static void main(String[] args) throws ParseException {
		
	/* String[] test1 = test1("abc123def45ghi67");
	 System.out.println(Arrays.toString(test1));
	 
	 System.out.println("-=-----");
	 String []	test2 = test2("abc123def45ghi67");
	 System.out.println(Arrays.toString(test2));
	 System.out.println("-=-----");
	 */
	/* String []	test3 = test3("abc123def45ghi67");
	 System.out.println(Arrays.toString(test3));*/
		
		System.out.println(test4("2015-11-23 1:3:5","2015-11-25 2:3:8"));
	}

	private static String test4(String string, String string2) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date data1 = sdf.parse(string);
		Date data2 = sdf.parse(string2);
		long num=data2.getTime()-data1.getTime();
		Date date = new Date(num);
		
		long day = num/(1000*60*60*24);
		num=num%(1000*60*60*24);
		long hour = num/(1000*60*60);
		num=num%(1000*60*60);
		long min = num/(1000*60);
//		long day = num/(1000*60*60*24);
		
		System.out.println("day: "+day+" hour:"+hour+"min："+min);
		
		
		return null;
	}

	/**
	 * 
	 * @param string 字符串
	 * @return 数字的数组
	 */
	private static String[] test3(String string) {
		char[] array = string.toCharArray();
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			if(Character.isDigit(array[i])){
				sb.append(array[i]);
				if(i+1<array.length)
				if(!Character.isDigit(array[i+1])){
					sb.append(",");
				}
			}
		}
		return sb.toString().split(",");
	}

	private static String[] test2(String str) {
		
		char[] arr = str.toCharArray();
		Boolean [] flags=new Boolean[arr.length];
		int j=0;
		String str3="";
		for (int i = 0; i < arr.length; i++) {
			flags[i]=Character.isDigit(arr[i]);
			if(Character.isDigit(arr[i])){
				j++;
			}
		}
		String []str2=new String[j];
		j=0;
		for (int i = 0; i < arr.length; i++) {
			if(Character.isDigit(arr[i])){
				str2[j++]=arr[i]+"";
			}
		}
		
		return str2;
	}

	private static String[] test1(String str) {
		String[] arr = str.split("");
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			try{
				Integer.parseInt(arr[i]);
				j++;
			}catch(Exception e){
			}
		}
		String[] str2=new String[j];
		for (int i = 0; i < arr.length; i++) {
			try{
				Integer.parseInt(arr[i]);
				str2[j++]=arr[i];
			}catch(Exception e){
			}
		}
		return str2;
	}
	
}
