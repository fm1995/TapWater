package com.sy.entity;

import java.util.Date;

public class RdChangevalue {
    private Integer id;

    private Date datee;

    private Integer empId;

    private String userNo;

    private Integer preValue1;

    private Integer preValue2;

    private String remark;
    
    private SyEmp emp;
    
    private UsUser user;

    public SyEmp getEmp() {
		return emp;
	}

	public void setEmp(SyEmp emp) {
		this.emp = emp;
	}

	public UsUser getUser() {
		return user;
	}

	public void setUser(UsUser user) {
		this.user = user;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Integer getPreValue1() {
        return preValue1;
    }

    public void setPreValue1(Integer preValue1) {
        this.preValue1 = preValue1;
    }

    public Integer getPreValue2() {
        return preValue2;
    }

    public void setPreValue2(Integer preValue2) {
        this.preValue2 = preValue2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}