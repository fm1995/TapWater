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
import com.sy.entity.SyEmp;
import com.sy.mappdao.RdChangemaxvalueMapper;
import com.sy.projectUtils.rd.TermUtil;

/**
 * 最大表码修正记录业务处理层
 * @author xulong
 */
@Service
public class ChangeMaxValueService {
	@Autowired
	private RdChangemaxvalueMapper changeMaxValueMapper;
	
	/**
	 * 根据抄表员和修改时间段查询最大表码修正记录并写到前端 
	 * @param response
	 * @param term
	 * @param chang
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void selByTerm(HttpServletResponse response,TermUtil term,RdChangemaxvalue chang) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		List<RdChangemaxvalue> list=changeMaxValueMapper.selByTerm(term,chang);
		int count=changeMaxValueMapper.selByTermCount(term,chang);
		Map map=new HashMap<String, Object>();
		map.put("maxValues",list);
		map.put("count",count);
		map.put("pageCount",(count-1)/term.rows+1);
		mapToJson(response, map);
	}
	
	/**
	 * 将map转换为json并写到前端
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
