package com.sy.service.cbgl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdYearmonth;
import com.sy.mappdao.RdYearmonthMapper;
import com.sy.service.parentser.RdParentSer;

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
}
