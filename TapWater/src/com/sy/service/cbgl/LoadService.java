package com.sy.service.cbgl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdVolume;
import com.sy.entity.RdYearmonth;
import com.sy.entity.SyArea;
import com.sy.entity.SyEmp;
import com.sy.mappdao.RdVolumeMapper;
import com.sy.mappdao.RdYearmonthMapper;
import com.sy.mappdao.SyAreaMapper;
import com.sy.mappdao.SyEmpMapper;

/**
 * ҳ�����ҵ�����
 * @author xulong
 *
 */
@Service
public class LoadService {
	@Autowired
	private RdYearmonthMapper rdYearmonthMapper;
	@Autowired
	private RdVolumeMapper rdVolumeMapper;
	@Autowired
	private SyAreaMapper syAreaMapper;
	@Autowired
	private SyEmpMapper syEmpMapper;
	/**
	 * ��ѯȫ��Ͻ�� ��� �ͳ�������д��ǰ��ҳ��
	 * @param response
	 * @throws IOException 
	 */
	public void selAllAreaAndVolume(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<RdYearmonth> yearMonths =rdYearmonthMapper.selAll();
		List<RdVolume> volumes=rdVolumeMapper.selAll();
		List<SyArea> areas=syAreaMapper.selAll();
		System.out.println(yearMonths.size()+":"+volumes.size()+":"+areas.size());
		Map map=new HashMap<String,Object>();
		map.put("yearMonth", yearMonths);
		map.put("volumes",volumes);
		map.put("areas", areas);
		mapToJson(response,map);
		
	}
	
	/**
	 * ��ѯ���г����Ա����д��ǰ��
	 * @throws IOException 
	 */
	public void selByRdEmp(HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		List<SyEmp> emps=syEmpMapper.selEmpByDeptId(4);
		System.out.println(emps.size());
		String data=new Gson().toJson(emps);
		response.getWriter().write(data);
	}
	
	/**
	 * ��mapת��Ϊjson��д��ǰ��
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
