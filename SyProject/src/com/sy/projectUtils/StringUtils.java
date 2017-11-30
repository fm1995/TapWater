package com.sy.projectUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;


public class StringUtils {

	/**
	 * 创建长度为len的由"0"组成的字符串
	 * @param len
	 * @return
	 */
	
	public static String convertToSpell(String chines,String firstChar){
		String pinyinName="";
		char [] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat=new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for(int i =0;i<chines.length();i++){
			String s= String.valueOf(nameChar[i]);
			if(s.matches("[\\u4e00-\\u9fa5]")){
				try{
					if(firstChar.equals("1")){
						pinyinName+=PinyinHelper.toHanyuPinyinStringArray(nameChar[i],defaultFormat)[0].charAt(0);
					}else if(firstChar.equals("0")){
						pinyinName+=PinyinHelper.toHanyuPinyinStringArray(nameChar[i],defaultFormat)[0];
					}
					
				}catch(Exception ex){
					
				}
				
				
			}else if(s.matches("[a-z]") || s.matches("[A-Z]") || s.matches("[0-9]")){
				
				pinyinName+=s;
			}
			
		}
		return pinyinName.toLowerCase();
	}
	
	
}
