package com.sy.projectUtils;

import java.util.Arrays;


/**
 * 收费管理
 * @author BarryLiu
 *
 */
public class SfglDto {
	
	
	private Integer page =1;
	private Integer rows =5;
	
	private Integer pageCount;
	private Integer userMoney;
	private String whereStr;
	
// 用于 收费情况报表 的参数查询
	//用户编码
	private String userNo;
	//收费人员
	private Integer empId;
	//收费日期 (开始时间,结束时间)
	private String payDateBefore;
	private String payDateAfter;
	private String date;	//用于	发票补开/作废 的模糊查询
	//发票号码(开始号码,结束号码)
	private String ivNoBefore;
	private String ivNoAfter;
	private String invoiceNo; //用于	发票补开/作废 的模糊查询
	
//  用于查询 用户欠费情况  这个查询还用到 payDateBefore与payDateAfter 来携带参数
	// 排列方式    如果是 user_no 就是以用户编码来排列,如果是 bill_money就是以欠费金额来排序
	private String orderStr="user_no";
	

//	用于查询  各类用水统计总表
	private Integer typee=0; //是0表示	查询按月份统计 1表示按年份份统计
	
	private String year;	//按年统计的  统计年份下拉框
	private String yMonth;  //按月统计的  统计年月下拉框
	
//  用于欠费报表 
	//private String invoiceStr; //携带选择要查询的区域的id  eg：1,3,5,6,
	private String[] volume;   //携带要查询的区域的id
	
	
	
	 
	@Override
	public String toString() {
		return "SfglDto [page=" + page + ", rows=" + rows + ", pageCount="
				+ pageCount + ", userMoney=" + userMoney + ", whereStr="
				+ whereStr + ", userNo=" + userNo + ", empId=" + empId
				+ ", payDateBefore=" + payDateBefore + ", payDateAfter="
				+ payDateAfter + ", date=" + date + ", ivNoBefore="
				+ ivNoBefore + ", ivNoAfter=" + ivNoAfter + ", invoiceNo="
				+ invoiceNo + ", orderStr=" + orderStr + ", typee=" + typee
				+ ", year=" + year + ", yMonth=" + yMonth + ", volume="
				+ Arrays.toString(volume) + "]";
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}


	public String[] getVolume() {
		return volume;
	}


	public void setVolume(String[] volume) {
		this.volume = volume;
	}


	public Integer getTypee() {
		return typee;
	}

	public void setTypee(Integer typee) {
		this.typee = typee;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getyMonth() {
		return yMonth;
	}
	public void setyMonth(String yMonth) {
		this.yMonth = yMonth;
	}
	public String getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Integer getEmpId() {
		return empId;
	}

	public String getPayDateBefore() {
		return payDateBefore;
	}
	public void setPayDateBefore(String payDateBefore) {
		this.payDateBefore = payDateBefore;
	}
	public String getPayDateAfter() {
		return payDateAfter;
	}
	public void setPayDateAfter(String payDateAfter) {
		this.payDateAfter = payDateAfter;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	 
	public String getIvNoBefore() {
		return ivNoBefore;
	}

	public void setIvNoBefore(String ivNoBefore) {
		this.ivNoBefore = ivNoBefore;
	}



	public String getIvNoAfter() {
		return ivNoAfter;
	}



	public void setIvNoAfter(String ivNoAfter) {
		this.ivNoAfter = ivNoAfter;
	}



	public Integer getPageCount() {
		return pageCount;
	}


	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}


	public String getWhereStr() {
		return whereStr;
	}

	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}

	public Integer getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(Integer userMoney) {
		this.userMoney = userMoney;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	
}
