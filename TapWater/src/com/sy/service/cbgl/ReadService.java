package com.sy.service.cbgl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ReadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdRead;
import com.sy.entity.ReadView;
import com.sy.mappdao.RdReadMapper;
import com.sy.projectUtils.cbgl.TermUtil;

/**
 * @author xulong
 * 抄表数据业务处理层
 */
@Service
public class ReadService {
	@Autowired
	private RdReadMapper rdReadMapper;
	
	/**
	 * 根据年份和月份查询抄表情况报表并写到前端
	 * @param response
	 * @param read
	 * @throws IOException
	 */
	public void selByYearAndMonth(HttpServletResponse response, RdRead read) throws IOException {
		List<ReadView> list = rdReadMapper.selByYearAndMonth(read);
		response.setContentType("text/html;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * 根据条件分页查询0吨水用户并写到前端
	 * @param response
	 * @param term
	 * @param read
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void selReadByTerm(HttpServletResponse response,TermUtil term,RdRead read) throws IOException{
		List<RdRead> list=rdReadMapper.selReadByTerm(term,read);
		int userCount=selReadByTermUserCount(term,read);
		int count = selReadByTermCount(term, read);
		@SuppressWarnings("rawtypes")
		Map map=new HashMap<String,Object>();
		@SuppressWarnings("static-access")
		int pageCount=(count-1)/term.rows+1;
		map.put("pageCount",pageCount>0?pageCount:1);
		map.put("list",list);
		map.put("userCount",userCount);
		mapToJson(response, map);
	}
	
	/**
	 * 根据条件查询0吨位用水量用户总和
	 * @param term
	 * @param read
	 * @return
	 */
	private int selReadByTermUserCount(TermUtil term, RdRead read) {
		int userCount=rdReadMapper.selReadByTermUserCount(term,read);
		return userCount;
	}

	/**
	 * 根据条件分页查询0吨水用户的总页数
	 * @param request
	 * @param term
	 * @param read
	 */
	public int selReadByTermCount(TermUtil term,RdRead read){
		int count=rdReadMapper.selReadByTermCount(term,read);
		return count;
	}
	
	/**
	 * 将map转换为json并写到前端
	 * @param response
	 * @param map
	 */
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
