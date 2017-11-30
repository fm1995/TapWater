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
 * 抄表数据控制类
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
	 * 异步根据年份和月份查询抄表情况报表
	 * @param response
	 * @param read
	 * @throws IOException
	 */
	@RequestMapping("/selByYearAndMonth")
	public void selByYearAndMonth(HttpServletResponse response,RdRead read) throws IOException{
		readService.selByYearAndMonth(response,read);
	}
	
	/**
	 * 查询所有的辖区和表册并跳转到零吨位用户查询页面
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
	 * 异步根据条件分页查询0吨水用户,并查询总页数
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
	 * 查询当月要初始化抄表的总用户
	 * @throws IOException 
	 */
	@RequestMapping("/selReadCount")
	public void selReadCount(HttpServletResponse response) throws IOException{
		readService.loadUserCount(response);
	}
	
	/**
	 * 判断当前这个月用没有初始化抄表数据
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/isInit")
	public void isInit(HttpServletResponse response) throws IOException{
		readService.isInit(response);
	}
	
	/**
	 * 初始化抄表年月,表册任务分配和当前月的抄表数据
	 */
	@RequestMapping("initUserRead")
	public void initUserRead(HttpServletRequest request){
		readService.initUserRead(request);
	}
	
	/**
	 * 根据表册ID查询未审核的用户
	 * @throws IOException 
	 */
	@RequestMapping("/selReadByVolumeId")
	public void selReadByVolumeId(HttpServletResponse response, int volumeId) throws IOException{
		readService.selReadByVolumeId(response,volumeId);
	}
	
	/**
	 * 根据输入的用户信息模糊查询审核
	 * @param response
	 * @param user
	 * @throws IOException 
	 */
	@RequestMapping("/selReadByUser")
	public void selReadByUser(HttpServletResponse response,UsUser user) throws IOException{
		readService.selReadByUser(response,user);
	}
	
	/**
	 * 根据抄表Id进行抄表审核，同时产生水费单
	 * @param response
	 * @param readId
	 */
	@RequestMapping("/readAudit")
	public void readAuditByReadId(HttpServletRequest request,HttpServletResponse response,int readId){
		readService.readAuditByReadId(request,response,readId);
	}
}
