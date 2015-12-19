package com.sy.entity.view;

import com.sy.entity.UsMeter;

public class MeterView {
	
	private String userNo;
	
	private String userName;
	
	private String meterType;
	
	private UsMeter meter;

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

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public UsMeter getMeter() {
		return meter;
	}

	public void setMeter(UsMeter meter) {
		this.meter = meter;
	}
	
	

}
