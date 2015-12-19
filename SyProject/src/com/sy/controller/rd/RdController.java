package com.sy.controller.rd;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.entity.RdRead;
import com.sy.entity.RdTask;
import com.sy.entity.RdVolume;
import com.sy.entity.RdYearmonth;
import com.sy.projectUtils.TerUtil;
import com.sy.service.rd.LoadService;
import com.sy.service.rd.RdReadService;
import com.sy.service.rd.RdVolumeService;

@Controller
@RequestMapping("/RdController")
public class RdController {

	// private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private RdReadService rdReadService;
	@Autowired
	private RdVolumeService rdVolumeService;
	@Autowired
	private LoadService loadService;

	public void setLoadService(LoadService loadService) {
		this.loadService = loadService;
	}

	public void setRdReadService(RdReadService rdReadService) {
		this.rdReadService = rdReadService;
	}

	public void setRdVolumeService(RdVolumeService rdVolumeService) {
		this.rdVolumeService = rdVolumeService;
	}

	// �������--�������ʼ��-----------------------------------------------------
	@RequestMapping("/queryAll")
	public void queryAll(HttpServletResponse resp) throws ParseException {
		rdReadService.selAll_yearmonth(resp);
	}

	// �첽�ύ
	@RequestMapping("/initRdYearMonth")
	@ResponseBody
	public List<RdYearmonth> intiYearMonth(ModelMap map, HttpServletRequest req) {
		rdReadService.initYearMonth(req);
		return null;
	}

	// �������--��ˮ�����ڱ���
	@RequestMapping("/queryToReportMeterCheck")
	public void queryToReportMeterCheck(TerUtil tu, HttpServletResponse resp) {
		rdReadService.queryToReportMeterCheck(tu, resp);
	}

	// �������--��������� ��ѯ
	@RequestMapping("/queryToRdTask")
	public void queryToRdTask(HttpServletResponse resp) {
		rdReadService.queryToRdTask(resp);
	}

	// ��ѯĳ��������ϸ��Ϣ
	@RequestMapping("/queryRdVolume")
	public void queryRdVolume(RdVolume rdVolume, HttpServletResponse resp) {
		rdVolumeService.queryRdVolume(rdVolume, resp);
	}

	// �������--��������� ����
	@RequestMapping("/taskDistribute")
	public void taskDistribute(RdTask rt, HttpServletResponse resp) {
		rdReadService.upRdTask(rt, resp);
	}

	// �������--�����������ѯ(��ʼ������)
	@RequestMapping("/initData")
	public void initData(HttpServletResponse resp) throws IOException {
		loadService.selAllAreaAndVolume(resp);
	}

	// �������--�����������ѯ
	@RequestMapping("/queryRdReadData")
	public void queryRdRead(RdRead rdRead, TerUtil tu, HttpServletResponse resp) {
		rdReadService.queryRdRead(rdRead, tu, resp);
	}

}
