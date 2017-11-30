package com.sy.entity;

import java.util.Date;

import com.sy.entity.page.Page;

public class BeOrderlite {
    private Integer id;

    private Integer orderType;

    private Date datee;

    private Integer empId;

    private String userNo;

    private String userName;

    private String description;
    
    //新添加辅助字段 展示必要信息
    private String orderTypeString;
    private String empName;
    private String dateeTime;
    private Page page;
    
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getDateeTime() {
		return dateeTime;
	}

	public void setDateeTime(String dateeTime) {
		this.dateeTime = dateeTime;
	}

	public String getOrderTypeString() {
		return orderTypeString;
	}

	public void setOrderTypeString(String orderTypeString) {
		this.orderTypeString = orderTypeString;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}