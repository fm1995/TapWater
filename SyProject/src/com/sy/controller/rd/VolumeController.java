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
 * ������Ʋ�
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
	 * ��ӱ��
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
	 * ���ݱ��IDɾ�����,���޸Ĵ˱���µ��û��ı��ID Ϊ��
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
	 * ���ݱ��id��ѯ���
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
	 * ����id�޸ı��
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
	 * ��ѯ��ǰ�µĸ�������
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selByAuditPage")
	public void selByAuditPage(HttpServletResponse response) throws IOException{
		volumeService.selByAuditPage(response);
	}
	
	/**
	 * ���ݱ�����Ʋ�ѯ���
	 * @param response
	 * @param volumeName
	 * @throws IOException 
	 */
	@RequestMapping("/selByVolumeName")
	public void selByVolumeName(HttpServletResponse response,String volumeName) throws IOException{
		volumeService.selByVolumeName(response,volumeName);
	}
}
