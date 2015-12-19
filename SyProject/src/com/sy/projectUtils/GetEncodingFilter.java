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
		HttpServletRequest req= (HttpServletRequest) request;
		if(!(req.getRequestURI().contains(".css")||req.getRequestURI().contains(".png"))){
			if(req.getMethod().equalsIgnoreCase("GET"))
				conventGetEncoder(req);
		}
			chain.doFilter(request, response);
	}

	//get·½Ê½±àÂë
	private void conventGetEncoder(HttpServletRequest req){
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
