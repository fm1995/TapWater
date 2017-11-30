package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdVolume;
import com.sy.service.rd.RdUserService;
import com.sy.service.rd.VolumeService;

/**
 * 表册表控制层
 * 
 * @author xulong
 */

@Controller
@RequestMapping("/SY/page/volume")
public class VolumeController {
	@Autowired
	private VolumeService volumeService;
	@Autowired
	private RdUserService userService;

	/**
	 * 添加表册
	 * 
	 * @param response
	 * @param volume
	 * @throws IOException
	 */
	@RequestMapping("/add")
	public void add(HttpServletResponse response, RdVolume volume)
			throws IOException {
		volumeService.add(response, volume);
	}

	/**
	 * 根据表册ID删除表册,并修改此表册下的用户的表册ID 为空
	 * 
	 * @param response
	 * @param volumeId
	 */
	@RequestMapping("/delById")
	public void delById(HttpServletResponse response, int volumeId) {
		userService.UpVolumeId(volumeId);
		volumeService.delById(response, volumeId);
	}

	/**
	 * 根据表册id查询表册
	 * 
	 * @param response
	 * @param volumeId
	 * @throws IOException
	 */
	@RequestMapping("/selById")
	public void selById(HttpServletResponse response, int volumeId)
			throws IOException {
		volumeService.selById(response, volumeId);
	}

	/**
	 * 根据id修改表册
	 * 
	 * @param response
	 * @param volume
	 * @throws IOException
	 */
	@RequestMapping("/upById")
	public void upById(HttpServletResponse response, RdVolume volume)
			throws IOException {
		volumeService.upById(response, volume);
	}
	
	/**
	 * 查询当前月的复核数据
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selByAuditPage")
	public void selByAuditPage(HttpServletResponse response) throws IOException{
		volumeService.selByAuditPage(response);
	}
	
	/**
	 * 根据表册名称查询表册
	 * @param response
	 * @param volumeName
	 * @throws IOException 
	 */
	@RequestMapping("/selByVolumeName")
	public void selByVolumeName(HttpServletResponse response,String volumeName) throws IOException{
		volumeService.selByVolumeName(response,volumeName);
	}
}
