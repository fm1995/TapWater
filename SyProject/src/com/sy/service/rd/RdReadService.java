package com.sy.service.rd;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sy.entity.RdRead;
import com.sy.entity.RdTask;
import com.sy.entity.RdTaskExample;
import com.sy.entity.RdTaskExample.Criteria;
import com.sy.entity.RdVolume;
import com.sy.entity.RdYearmonth;
import com.sy.entity.UsMeter;
import com.sy.projectUtils.TerUtil;
import com.sy.projectUtils.ValueVerify;

@Service
public class RdReadService extends RdParent {
	// ���ĵ�ˮ��
	public Double selReadAmount() {
		return ValueVerify.isnull(double.class, getRdReadMapper()
				.selReadAmount());
	}

	// Ӧ����ʵ��
	public Integer selReadCount(Integer enter) {
		return ValueVerify.isnull(Integer.class, getRdReadMapper()
				.selReadCount(enter));
	}

	// ���¸�����ˮ�� Ҫ���������ˮ���͵Ĵ���
	public Double sumTypeAmount(String type) {
		return ValueVerify.isnull(double.class, getRdReadMapper()
				.sumTypeAmount(type));
	}

	//----------------------------------------------------------------------------------

	// ��ѯ���е�rdYearMonth����
	public void selAll_yearmonth(HttpServletResponse resp) throws ParseException {
		/*List<RdYearmonth> list = rdYearmonthMapper.selToRdInit();
		String json = new Gson().toJson(list);
		sendToClient(json,resp);*/
	}

	public void initYearMonth(HttpServletRequest req) {
		// ��Session�еõ���ʼ�������˵�ID
		int initEmpId = 0;
		Object empId = req.getSession().getAttribute("empId");
		if (!empId.equals("")) {
			initEmpId = Integer.parseInt(empId.toString());
		}
		// ��'rd_yearmonth'���в���һ��������
		RdYearmonth r = new RdYearmonth();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(date);
		String[] drr = sdate.split("-");
		int year = Integer.parseInt(drr[0]);
		int month = Integer.parseInt(drr[1]);
		r.setReadYear(year);
		r.setReadMonth(month);
		r.setIsCurrent(true);
		r.setInitEmpId(initEmpId);
		r.setInitDate(date);
		System.out.println(r);
		rdYearmonthMapper.insertSelective(r);

	}

	//	ˮ�����ڱ���
	public void queryToReportMeterCheck(TerUtil tu,HttpServletResponse resp) {
		List<UsMeter> list1=usMeterMapper.selToReportMeterCheck(tu);
		int count=usMeterMapper.selCount(tu);
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("list", list1);
		data.put("count", count);
		data.put("pageTota", (count-1)/tu.getPageSize()+1);
		String json = new Gson().toJson(data);
		sendToClient(json,resp);
	}
	
	//	����̨�����ݴ��䵽ǰ��
	private void sendToClient(String data,HttpServletResponse resp){
		try {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	������������ѯ
	public void queryToRdTask(HttpServletResponse resp) {
		List<RdTask> list=rdTaskMapper.queryToRdTask();
		String data = new Gson().toJson(list);
		sendToClient(data, resp);
	}
	
	//	�������--���������  ����
	public void upRdTask(RdTask rt,HttpServletResponse resp) {
		RdTaskExample example=new RdTaskExample();
		Criteria criteria = example.createCriteria();
		criteria.andVolumeIdEqualTo(rt.getVolumeId());
		rdTaskMapper.updateByExampleSelective(rt, example);
		
		resp.setContentType("text/html;charset=utf-8");
		try {
			resp.getWriter().write("����ɹ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//	�������--�����������ѯ(��ʼ������)
	public void queryInitData(HttpServletResponse resp) {
		List<RdYearmonth> rdYearMonths = rdYearmonthMapper.selAll();
		List<RdVolume> rdVolumes = rdVolumeMapper.selAll();
		System.out.println(+rdYearMonths.size()+"...."+rdVolumes.size());
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("rdYearMonths", rdYearMonths);
		data.put("rdVolumes", rdVolumes);
		String json = new Gson().toJson(data);
		sendToClient(json, resp);
	}

	//	�������--�����������ѯ
	public void queryRdRead(RdRead rdRead,TerUtil tu, HttpServletResponse resp) {
		List<RdRead> list=rdReadMapper.queryVolumeDetails(rdRead,tu);
		int count=rdReadMapper.queryVolumeDetailsCount(rdRead,tu);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rdReads", list);
		map.put("count", count);
		map.put("pagi", (count-1)/tu.getPageSize()+1);
		String json = new Gson().toJson(map);
		sendToClient(json, resp);
	}

	

}