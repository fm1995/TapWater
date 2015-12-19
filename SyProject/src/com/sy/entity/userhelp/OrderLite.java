package com.sy.entity.userhelp;

import java.util.Date;

import com.sy.entity.page.Page;

public class OrderLite {
	private Integer orderType;
	private Integer empId;
	private String stratDatee;  //��̨����ǰ̨��������Сʱ��ֵ
	private String stopDatee;   //��̨����ǰ̨���������ʱ��ֵ
	private Date stratTime;    //ǰ̨��ʾ��̨��������Сʱ��ֵ
	private Date stopTime;     //ǰ̨��ʾ��̨���������ʱ��ֵ
	
	private Page page;
	public OrderLite(Integer orderType, Integer empId, String stratDatee,
			String stopDatee, Date stratTime, Date stopTime) {
		
		this.orderType = orderType;
		this.empId = empId;
		this.stratDatee = stratDatee;
		this.stopDatee = stopDatee;
		this.stratTime = stratTime;
		this.stopTime = stopTime;
	}
	public OrderLite(Integer orderType, Integer empId, Date stratTime, Date stopTime) {
		
		this.orderType = orderType;
		this.empId = empId;
		this.stratTime = stratTime;
		this.stopTime = stopTime;
	}
	public OrderLite() {
		
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getEmpNo() {
		return empId;
	}
	public void setEmpNo(Integer empId) {
		this.empId = empId;
	}
	public String getStratDatee() {
		return stratDatee;
	}
	public void setStratDatee(String stratDatee) {
		this.stratDatee = stratDatee;
	}
	public String getStopDatee() {
		return stopDatee;
	}
	public void setStopDatee(String stopDatee) {
		this.stopDatee = stopDatee;
	}
	public Date getStratTime() {
		return stratTime;
	}
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	
	

}
