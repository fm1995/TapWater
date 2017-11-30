package com.sy.entity;

public class RdTask {
    private Integer id;

    private Integer readYear;

    private Integer readMonth;

    private Integer volumeId;

    private Integer empId;
    
    //	¼¶ÁªÊôÐÔ
    private SyEmp syEmp;
    
    private RdVolume rdVolume;

	public RdVolume getRdVolume() {
		return rdVolume;
	}

	public void setRdVolume(RdVolume rdVolume) {
		this.rdVolume = rdVolume;
	}

	public SyEmp getSyEmp() {
		return syEmp;
	}

	public void setSyEmp(SyEmp syEmp) {
		this.syEmp = syEmp;
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

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}