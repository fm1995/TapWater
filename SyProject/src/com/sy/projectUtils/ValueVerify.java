package com.sy.projectUtils;

import java.math.BigDecimal;

//ֵУ��
public class ValueVerify {
	//��ֵУ��
	@SuppressWarnings("unchecked")
	public static <T> T isnull(Class<T> c,Object obj){
		if(c==double.class||c==Double.class){
			return (T) (obj==null?0.0:obj);
		}else if (c==Integer.class||c==int.class) {
			return (T) (obj==null?0:obj);
		}else if(c==Boolean.class||c==boolean.class){
			return (T) (obj==null?0:obj);
		}else if(c==BigDecimal.class){
			return (T) (obj==null?new BigDecimal(0.0):obj);
		}else if(c==String.class){
			return (T) (obj==null?new String(""):obj);
		}else{
			return (T) (obj==null?"":obj);
		}
	 } 
}
