package com.sy.service.cbgl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sy.entity.SyArea;
import com.sy.mappdao.SyAreaMapper;

/**
 * 
 * @author xulong
 * 抄表辖区业务层
 */
@Service
public class AreaService {
	@Autowired
	private SyAreaMapper syAreaMapper;
	
	/**
	 * 查询所有抄表辖区
	 * @param map
	 */
	public void selAll(ModelMap map){
		List<SyArea>list=syAreaMapper.selAll();
		map.put("areas", list);
	}
}
