package com.sy.entity;

/**
 * 
 * @author xulong
 * 抄表情况统计报表视图类
 */
public class ReadView {
	private String area;
	private String volume;
	private String empName;
	private Integer count;
	private Integer enterYes;
	private Integer enterNo;
	private Integer auditYes;
	private Integer auditNo;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getEnterYes() {
		return enterYes;
	}
	public void setEnterYes(Integer enterYes) {
		this.enterYes = enterYes;
	}
	public Integer getEnterNo() {
		return enterNo;
	}
	public void setEnterNo(Integer enterNo) {
		this.enterNo = enterNo;
	}
	public Integer getAuditYes() {
		return auditYes;
	}
	public void setAuditYes(Integer auditYes) {
		this.auditYes = auditYes;
	}
	public Integer getAuditNo() {
		return auditNo;
	}
	public void setAuditNo(Integer auditNo) {
		this.auditNo = auditNo;
	}
	
}
