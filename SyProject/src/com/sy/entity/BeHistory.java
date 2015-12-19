package com.sy.entity;

import java.util.Date;

public class BeHistory {
	@Override
	public String toString() {
		return "BeHistory [id=" + id + ", orderNo=" + orderNo + ", stepId="
				+ stepId + ", datee=" + datee + ", empId=" + empId
				+ ", isBack=" + isBack + ", emp=" + emp + ", order=" + order
				+ ", stepName=" + stepName + "]";
	}

	private Integer id;

	private String orderNo;

	private Integer stepId;

	private Date datee;

	private Integer empId;

	private Boolean isBack;

	private SyEmp emp;

	private BeOrder order;
	
	//Mapper文件中为定义，用于jsp页面取值。封装
	private String stepName;

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public SyEmp getEmp() {
		return emp;
	}

	public void setEmp(SyEmp emp) {
		this.emp = emp;
	}

	public BeOrder getOrder() {
		return order;
	}

	public void setOrder(BeOrder order) {
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Boolean getIsBack() {
		return isBack;
	}

	public void setIsBack(Boolean isBack) {
		this.isBack = isBack;
	}
}