package com.sy.integration.iv;

import java.util.Date;
		/**发票管理
		 * 发票交票封装类
		 *
		 */
public class ArchiveReturnClass {
	private Integer id,counts,ivUsed,ivInvalid;
	private String startNo,endNo,sEmpName,jEmpName;
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getIvUsed() {
		return ivUsed;
	}
	public void setIvUsed(Integer ivUsed) {
		this.ivUsed = ivUsed;
	}
	public Integer getIvInvalid() {
		return ivInvalid;
	}
	public void setIvInvalid(Integer ivInvalid) {
		this.ivInvalid = ivInvalid;
	}
	public String getStartNo() {
		return startNo;
	}
	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}
	public String getEndNo() {
		return endNo;
	}
	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
	public String getsEmpName() {
		return sEmpName;
	}
	public void setsEmpName(String sEmpName) {
		this.sEmpName = sEmpName;
	}
	public String getjEmpName() {
		return jEmpName;
	}
	public void setjEmpName(String jEmpName) {
		this.jEmpName = jEmpName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "InvlvoiceReportArchive [id=" + id + ", counts=" + counts
				+ ", ivUsed=" + ivUsed + ", ivInvalid=" + ivInvalid
				+ ", startNo=" + startNo + ", endNo=" + endNo + ", sEmpName="
				+ sEmpName + ", jEmpName=" + jEmpName + ", date=" + date + "]";
	}
	
	
	
}
