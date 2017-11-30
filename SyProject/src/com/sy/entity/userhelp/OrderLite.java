package com.sy.entity.userhelp;

import java.util.Date;

import com.sy.entity.page.Page;

public class OrderLite {
	private Integer orderType;
	private Integer empId;
	private String stratDatee;  //后台保存前台传来的最小时间值
	private String stopDatee;   //后台保存前台传来的最大时间值
	private Date stratTime;    //前台显示后台传来的最小时间值
	private Date stopTime;     //前台显示后台传来的最大时间值
	
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
