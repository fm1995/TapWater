package com.sy.service.rd;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdChangemaxvalue;
import com.sy.entity.RdChangevalue;
import com.sy.mappdao.RdChangevalueMapper;
import com.sy.projectUtils.rd.TermUtil;

/**
 * ����������¼ҵ�����
 * @author xulong
 */

@Service
public class ChangeValueService {
	@Autowired
	private RdChangevalueMapper changeValueMapper;
	
	/**
	 * ��������ʱ��κ������˲�ѯ��������д��ǰ��
	 * @param response
	 * @param term
	 * @param chang
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void selByTerm(HttpServletResponse response,TermUtil term,RdChangevalue chang){
		List<RdChangevalue> list=changeValueMapper.selByTerm(term,chang);
		int count=changeValueMapper.selByTermCount(term,chang);
		Map map=new HashMap<String,Object>();
		map.put("changValues",list);
		map.put("count",count);
		map.put("pageCount",(count-1)/term.rows+1);
		mapToJson(response, map);
	}
	
	
	/**
	 * ��mapת��Ϊjson��д��ǰ��
	 * @param response
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	private void mapToJson(HttpServletResponse response,Map map){
		String json = new Gson().toJson(map);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
