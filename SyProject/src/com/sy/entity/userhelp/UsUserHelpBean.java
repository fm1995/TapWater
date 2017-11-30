package com.sy.entity.userhelp;

import com.sy.entity.page.Page;

public class UsUserHelpBean {
	
	private String userNo;
	
	private String userName;
	
	private String smsPhone;
	
	private String sendOut;
	
	private String userType;
	
	private Double userMoney;
	
	private Page page;

	
	public Double getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSmsPhone() {
		return smsPhone;
	}

	public void setSmsPhone(String smsPhone) {
		this.smsPhone = smsPhone;
	}

	public String getSendOut() {
		return sendOut;
	}

	public void setSendOut(String sendOut) {
		this.sendOut = sendOut;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	

}
