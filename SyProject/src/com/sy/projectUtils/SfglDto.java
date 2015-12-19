package com.sy.projectUtils;

import java.util.Arrays;


/**
 * �շѹ���
 * @author BarryLiu
 *
 */
public class SfglDto {
	
	
	private Integer page =1;
	private Integer rows =5;
	
	private Integer pageCount;
	private Integer userMoney;
	private String whereStr;
	
// ���� �շ�������� �Ĳ�����ѯ
	//�û�����
	private String userNo;
	//�շ���Ա
	private Integer empId;
	//�շ����� (��ʼʱ��,����ʱ��)
	private String payDateBefore;
	private String payDateAfter;
	private String date;	//����	��Ʊ����/���� ��ģ����ѯ
	//��Ʊ����(��ʼ����,��������)
	private String ivNoBefore;
	private String ivNoAfter;
	private String invoiceNo; //����	��Ʊ����/���� ��ģ����ѯ
	
//  ���ڲ�ѯ �û�Ƿ�����  �����ѯ���õ� payDateBefore��payDateAfter ��Я������
	// ���з�ʽ    ����� user_no �������û�����������,����� bill_money������Ƿ�ѽ��������
	private String orderStr="user_no";
	

//	���ڲ�ѯ  ������ˮͳ���ܱ�
	private Integer typee=0; //��0��ʾ	��ѯ���·�ͳ�� 1��ʾ����ݷ�ͳ��
	
	private String year;	//����ͳ�Ƶ�  ͳ�����������
	private String yMonth;  //����ͳ�Ƶ�  ͳ������������
	
//  ����Ƿ�ѱ��� 
	//private String invoiceStr; //Я��ѡ��Ҫ��ѯ�������id  eg��1,3,5,6,
	private String[] volume;   //Я��Ҫ��ѯ�������id
	
	
	
	 
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
