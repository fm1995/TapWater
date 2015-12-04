package com.sy.service.cbgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sy.entity.RdVolume;
import com.sy.mappdao.RdVolumeMapper;

/**
 * ���ҵ�����
 * @author xulong
 */
@Service
public class VolumeService {
	@Autowired
	private RdVolumeMapper rdVolumeMapper;
	
	/**
	 * ��ѯ���б��
	 * @param map
	 */
	public void selAll(ModelMap map){
		List<RdVolume> list=rdVolumeMapper.selAll();
		map.put("volumes", list);
	}
	
}
