package com.sy.service.rd;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.google.gson.Gson;
import com.sy.entity.RdVolume;
import com.sy.entity.VolumeView;
import com.sy.mappdao.RdVolumeMapper;
import com.sy.mappdao.UsUserMapper;

/**
 * 表册业务处理层
 * @author xulong
 */
@Service
public class VolumeService {
	@Autowired
	private RdVolumeMapper rdVolumeMapper;
	
	/**
	 * 查询所有表册 并写出添加结果到前端页面
	 * @param map
	 */
	public void selAll(ModelMap map){
		List<RdVolume> list=rdVolumeMapper.selAll();
		map.put("volumes", list);
	}
	
	/**
	 * 添加表册
	 * @param response
	 * @param volume
	 * @throws IOException
	 */
	public void add(HttpServletResponse response, RdVolume volume) throws IOException{
		int num =rdVolumeMapper.insertSelective(volume);
		String message="添加表册成功！";
		if(num<1)
			message="添加表册失败！";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(message);	
	}
	
	/**
	 * 根据Id删除表册
	 * @param response
	 * @param volumeId
	 */
	public void delById(HttpServletResponse response,int volumeId){
		rdVolumeMapper.deleteByPrimaryKey(volumeId);
	}
	
	/**
	 * 根据表册id查询表册并写到前端页面
	 * @param response
	 * @param volumeId
	 * @return
	 * @throws IOException 
	 */
	public void selById(HttpServletResponse response, int volumeId) throws IOException {
		RdVolume volume=rdVolumeMapper.selectByPrimaryKey(volumeId);
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(volume);
		response.getWriter().write(data);
	}

	/**
	 * 根据id修改表册并写回结果到前端页面
	 * @param response
	 * @param volume
	 * @throws IOException 
	 */
	public void upById(HttpServletResponse response, RdVolume volume) throws IOException {
		int num = rdVolumeMapper.updateByPrimaryKeySelective(volume);
		String message="修改表册成功！返回首页！";
		if(num<1)
			message="修改表册失败！返回首页！";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(message);
	}
	
	/**
	 * 查询当前月审核数据到并写到前端页面
	 * @param response
	 * @throws IOException 
	 */
	public void selByAuditPage(HttpServletResponse response) throws IOException {
		List<VolumeView> list=rdVolumeMapper.selByAuditPage();
		response.setContentType("text/json;charset=utf-8");
		String data=new Gson().toJson(list);
		response.getWriter().write(data);
	}
	
	/**
	 * 根据表册名称查询是否存在此用户，并返回结果
	 * @param response
	 * @param volumeName
	 * @throws IOException 
	 */
	public void selByVolumeName(HttpServletResponse response, String volumeName) throws IOException {
		int count=rdVolumeMapper.selByVolumeName(volumeName);
		if(count>0)
			response.getWriter().write("1");
		else
			response.getWriter().write("0");
		
	}
	
	
	
	
	
}
