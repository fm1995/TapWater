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
 * ����Ͻ��ҵ���
 */
@Service
public class AreaService {
	@Autowired
	private SyAreaMapper syAreaMapper;
	
	/**
	 * ��ѯ���г���Ͻ��
	 * @param map
	 */
	public void selAll(ModelMap map){
		List<SyArea>list=syAreaMapper.selAll();
		map.put("areas", list);
	}
}
