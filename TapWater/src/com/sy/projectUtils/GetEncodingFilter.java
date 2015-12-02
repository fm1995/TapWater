package com.sy.projectUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class GetEncodingFilter implements Filter{


	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rep= (HttpServletRequest) request;
		if(rep.getMethod().equalsIgnoreCase("GET"))
			conventGetEncoder(rep);
		
			chain.doFilter(request, response);
	}

	//get方式编码
	private void conventGetEncoder(HttpServletRequest req){
		@SuppressWarnings("unchecked")
		Map<String,String[]> map = req.getParameterMap();
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			for (int i = 0; i < values.length; i++) {
				try {
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
