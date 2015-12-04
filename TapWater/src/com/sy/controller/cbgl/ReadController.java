package com.sy.controller.cbgl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdRead;
import com.sy.projectUtils.cbgl.TermUtil;
import com.sy.service.cbgl.AreaService;
import com.sy.service.cbgl.ReadService;
import com.sy.service.cbgl.VolumeService;

/**
 * @author xulong
 * �������ݿ�����
 */
@Controller
@RequestMapping("/sy/page/read")
public class ReadController {
	@Autowired
	private ReadService readService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private VolumeService volumeService;
	
	/**
	 * �첽������ݺ��·ݲ�ѯ�����������
	 * @param response
	 * @param read
	 * @throws IOException
	 */
	@RequestMapping("/selByYearAndMonth")
	public void selByYearAndMonth(HttpServletResponse response,RdRead read) throws IOException{
		readService.selByYearAndMonth(response,read);
	}
	
	/**
	 * ��ѯ���е�Ͻ���ͱ�Ტ��ת�����λ�û���ѯҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping("/selAllAreaAndVolume")
	public String selAllAreaAndVolume(ModelMap map){
		areaService.selAll(map);
		volumeService.selAll(map);
		return "/SY/page/rd_reportZero.jsp";
	}
	
	/**
	 * �첽����������ҳ��ѯ0��ˮ�û�,����ѯ��ҳ��
	 * @param response
	 * @param term
	 * @param read
	 * @throws IOException
	 */
	@RequestMapping("/selReadByTerm")
	public void selReadByTerm(HttpServletResponse response,TermUtil term,RdRead read) throws IOException{
		readService.selReadByTerm(response,term, read);
	}
	
}
