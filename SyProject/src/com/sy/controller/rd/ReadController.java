package com.sy.controller.rd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.entity.RdRead;
import com.sy.entity.UsUser;
import com.sy.projectUtils.rd.TermUtil;
import com.sy.service.rd.AreaService;
import com.sy.service.rd.RdYearmonthService;
import com.sy.service.rd.ReadService;
import com.sy.service.rd.VolumeService;

/**
 * @author xulong
 * �������ݿ�����
 */
@Controller
@RequestMapping("/SY/page/read")
public class ReadController {
	@Autowired
	private ReadService readService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private VolumeService volumeService;
	@Autowired
	private RdYearmonthService yearMonthService;
	
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
	
	/**
	 * ��ѯ����Ҫ��ʼ����������û�
	 * @throws IOException 
	 */
	@RequestMapping("/selReadCount")
	public void selReadCount(HttpServletResponse response) throws IOException{
		readService.loadUserCount(response);
	}
	
	/**
	 * �жϵ�ǰ�������û�г�ʼ����������
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/isInit")
	public void isInit(HttpServletResponse response) throws IOException{
		readService.isInit(response);
	}
	
	/**
	 * ��ʼ����������,����������͵�ǰ�µĳ�������
	 */
	@RequestMapping("initUserRead")
	public void initUserRead(HttpServletRequest request){
		readService.initUserRead(request);
	}
	
	/**
	 * ���ݱ��ID��ѯδ��˵��û�
	 * @throws IOException 
	 */
	@RequestMapping("/selReadByVolumeId")
	public void selReadByVolumeId(HttpServletResponse response, int volumeId) throws IOException{
		readService.selReadByVolumeId(response,volumeId);
	}
	
	/**
	 * ����������û���Ϣģ����ѯ���
	 * @param response
	 * @param user
	 * @throws IOException 
	 */
	@RequestMapping("/selReadByUser")
	public void selReadByUser(HttpServletResponse response,UsUser user) throws IOException{
		readService.selReadByUser(response,user);
	}
	
	/**
	 * ���ݳ���Id���г�����ˣ�ͬʱ����ˮ�ѵ�
	 * @param response
	 * @param readId
	 */
	@RequestMapping("/readAudit")
	public void readAuditByReadId(HttpServletRequest request,HttpServletResponse response,int readId){
		readService.readAuditByReadId(request,response,readId);
	}
}
