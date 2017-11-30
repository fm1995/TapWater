package com.sy.entity;

import java.util.Date;

public class UsMeter {
	private Integer meterId;
	
    private String meterNo;

    private String userNo;

    private String meterName;

    private Integer meterTypeId;

    private Integer maxValue;

    private Integer startValue;

    private Date setupDate;
    
    private String setupTime;

    private String factory;

    private Boolean disabled;

    
    
    

    
    //	表龄
    private Integer meterAge;
    
    //级联属性
    private SyMeterType syMeterType;
    private UsUser usUser;


	public Integer getMeterId() {
		return meterId;
	}

	public void setMeterId(Integer meterId) {
		this.meterId = meterId;
	}

	public String getSetupTime() {
		return setupTime;
	}

	public void setSetupTime(String setupTime) {
		this.setupTime = setupTime;
	}

	public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo == null ? null : meterNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName == null ? null : meterName.trim();
    }

    public Integer getMeterTypeId() {
        return meterTypeId;
    }

    public void setMeterTypeId(Integer meterTypeId) {
        this.meterTypeId = meterTypeId;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getStartValue() {
        return startValue;
    }

    public void setStartValue(Integer startValue) {
        this.startValue = startValue;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

	public Integer getMeterAge() {
		return meterAge;
	}

	public void setMeterAge(Integer meterAge) {
		this.meterAge = meterAge;
	}

	public SyMeterType getSyMeterType() {
		return syMeterType;
	}

	public void setSyMeterType(SyMeterType syMeterType) {
		this.syMeterType = syMeterType;
	}

	public UsUser getUsUser() {
		return usUser;
	}

	public void setUsUser(UsUser usUser) {
		this.usUser = usUser;
	}
    
}