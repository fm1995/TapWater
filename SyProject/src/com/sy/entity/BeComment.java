package com.sy.entity;

import java.util.Date;

public class BeComment {
	private Integer id;

	private String orderNo;
	
	private Date datee;
	
	private Integer empId;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	private String comment;

	private SyEmp emp;

	private BeOrder order;
	public SyEmp getEmp() {
		return emp;
	}

	public void setEmp(SyEmp emp) {
		this.emp = emp;
	}

	public BeOrder getOrder() {
		return order;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	@Override
	public String toString() {
		return "BeComment [id=" + id + ", orderNo=" + orderNo + ", datee="
				+ datee + ", empId=" + empId + ", comment=" + comment
				+ ", emp=" + emp + ", order=" + order + "]";
	}
	
}