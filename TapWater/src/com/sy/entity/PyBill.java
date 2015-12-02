package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PyBill {
    private String billNo;

    private Integer readId;

    private String userNo;

    private Date createDate;

    private BigDecimal billMoney;

    private BigDecimal realMoney;

    private Boolean balance;

    private Date balanceDate;

    
    @Override
	public String toString() {
		return "PyBill [billNo=" + billNo + ", readId=" + readId + ", userNo="
				+ userNo + ", createDate=" + createDate + ", billMoney="
				+ billMoney + ", realMoney=" + realMoney + ", balance="
				+ balance + ", balanceDate=" + balanceDate + "]";
	}

	public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public Boolean getBalance() {
        return balance;
    }

    public void setBalance(Boolean balance) {
        this.balance = balance;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }
}