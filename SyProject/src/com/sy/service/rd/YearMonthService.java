package com.sy.service.rd;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdYearmonth;
import com.sy.mappdao.RdYearmonthMapper;

/**
 * @author xulong
 * ��������ҵ�����
 */
@Service
public class YearMonthService {
	@Autowired
	private RdYearmonthMapper rdYearmonthMapper;
	
	/**
	 * ��ѯ���г������²�д��ǰ��ҳ��
	 * @param response
	 * @throws IOException
	 */
	public void selAll(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		List<RdYearmonth> YearMonths =rdYearmonthMapper.selAll();
		String data=new Gson().toJson(YearMonths);
		response.getWriter().write(data);
	}
	
	/*public void test(HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		List<RdYearmonth> YearMonths =rdYearmonthMapper.selAll();
		System.out.println("size: "+YearMonths.size());
		Map map=new HashMap<String, Object>();
		map.put("draw", 2);
		map.put("recordsTotal",YearMonths.size());
		map.put("AO_DATA",YearMonths);
		map.put("recordsFiltered", 100);
		String data=new Gson().toJson(map);
		System.out.println(data);
		response.getWriter().write(data);
	}*/
	
	/**
	 * ��ѯ���г������¹���Ա����д��ǰ��ҳ��
	 * @param response
	 * @throws IOException 
	 */
	public void selAllAndEmp(HttpServletResponse response) throws IOException {
		List<RdYearmonth> list=rdYearmonthMapper.selAllAndEmp();
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
}
