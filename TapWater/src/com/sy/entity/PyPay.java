package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PyPay {
    private String payNo;

    private String userNo;

    private String payType;

    private Date payDate;

    private String invoice;

    private BigDecimal payMoney;

    private BigDecimal useMoney;

    private Integer empId;

    
    private SyEmp emp;
    
    @Override
	public String toString() {
		return "PyPay [payNo=" + payNo + ", userNo=" + userNo + ", payType="
				+ payType + ", payDate=" + payDate + ", invoice=" + invoice
				+ ", payMoney=" + payMoney + ", useMoney=" + useMoney
				+ ", empId=" + empId + ", emp=" + emp + "]";
	}

	public SyEmp getEmp() {
		return emp;
	}

	public void setEmp(SyEmp emp) {
		this.emp = emp;
	}

	public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(BigDecimal useMoney) {
        this.useMoney = useMoney;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}