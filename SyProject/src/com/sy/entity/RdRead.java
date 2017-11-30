package com.sy.entity;

import java.util.Date;
import java.util.List;

public class RdRead {
    private Integer id;

    private Integer readYear;

    private Integer readMonth;

    private String userNo;

    private String meterNo;

    private Integer maxValue;

    private Integer volumeId;

    private Integer volumeIndex;

    private Integer readEmpId;

    private Date readDate;

    private Integer preValue;

    private Boolean enter;

    private Integer curValue;

    private Boolean dial;

    private Integer amount;

    private String formula;

    private Boolean audit;

    private Integer auditEmpId;

    private Date auditDate;
    
    //	¼¶ÁªÊôÐÔ
    private UsUser usUser;
    
    private RdVolume rdVolume;
    
    private SyEmp syEmp;
    
    private RdTask rdTask;
    
    private List<RdReadtypes> readTypes;
    
    public List<RdReadtypes> getReadTypes() {
		return readTypes;
	}

	public void setReadTypes(List<RdReadtypes> readTypes) {
		this.readTypes = readTypes;
	}

	public RdTask getRdTask() {
		return rdTask;
	}

	public void setRdTask(RdTask rdTask) {
		this.rdTask = rdTask;
	}

	public SyEmp getSyEmp() {
		return syEmp;
	}

	public void setSyEmp(SyEmp syEmp) {
		this.syEmp = syEmp;
	}

	public RdVolume getRdVolume() {
		return rdVolume;
	}

	public void setRdVolume(RdVolume rdVolume) {
		this.rdVolume = rdVolume;
	}

	public UsUser getUsUser() {
		return usUser;
	}

	public void setUsUser(UsUser usUser) {
		this.usUser = usUser;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReadYear() {
        return readYear;
    }

    public void setReadYear(Integer readYear) {
        this.readYear = readYear;
    }

    public Integer getReadMonth() {
        return readMonth;
    }

    public void setReadMonth(Integer readMonth) {
        this.readMonth = readMonth;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo == null ? null : meterNo.trim();
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public Integer getVolumeIndex() {
        return volumeIndex;
    }

    public void setVolumeIndex(Integer volumeIndex) {
        this.volumeIndex = volumeIndex;
    }

    public Integer getReadEmpId() {
        return readEmpId;
    }

    public void setReadEmpId(Integer readEmpId) {
        this.readEmpId = readEmpId;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Integer getPreValue() {
        return preValue;
    }

    public void setPreValue(Integer preValue) {
        this.preValue = preValue;
    }

    public Boolean getEnter() {
        return enter;
    }

    public void setEnter(Boolean enter) {
        this.enter = enter;
    }

    public Integer getCurValue() {
        return curValue;
    }

    public void setCurValue(Integer curValue) {
        this.curValue = curValue;
    }

    public Boolean getDial() {
        return dial;
    }

    public void setDial(Boolean dial) {
        this.dial = dial;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Integer getAuditEmpId() {
        return auditEmpId;
    }

    public void setAuditEmpId(Integer auditEmpId) {
        this.auditEmpId = auditEmpId;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		RdRead rd=(RdRead)obj;
		if(this.hashCode()==rd.hashCode())
		{
			if(this.id==rd.getId())
				return true;
			else
				return false;
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "RdRead [id=" + id + ", readYear=" + readYear + ", readMonth="
				+ readMonth + ", userNo=" + userNo + ", meterNo=" + meterNo
				+ ", maxValue=" + maxValue + ", volumeId=" + volumeId
				+ ", volumeIndex=" + volumeIndex + ", readEmpId=" + readEmpId
				+ ", readDate=" + readDate + ", preValue=" + preValue
				+ ", enter=" + enter + ", curValue=" + curValue + ", dial="
				+ dial + ", amount=" + amount + ", formula=" + formula
				+ ", audit=" + audit + ", auditEmpId=" + auditEmpId
				+ ", auditDate=" + auditDate + "]";
	}

	
	
	
    
}