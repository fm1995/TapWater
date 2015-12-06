package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PyUserhistory {
    private Integer id;

    private String userno;

    private Integer typee;

    private String orderno;

    private Date datee;

    private Integer prevalue;

    private Integer curvalue;

    private Integer amount;

    private BigDecimal billmoney;

    private BigDecimal paymoney;

    private BigDecimal usermoney;
    
    //Î´½É½ð¶î
    private BigDecimal weipaymoney;
    
    

    @Override
	public String toString() {
		return "PyUserhistory [id=" + id + ", userno=" + userno + ", typee="
				+ typee + ", orderno=" + orderno + ", datee=" + datee
				+ ", prevalue=" + prevalue + ", curvalue=" + curvalue
				+ ", amount=" + amount + ", billmoney=" + billmoney
				+ ", paymoney=" + paymoney + ", usermoney=" + usermoney
				+ ", weipaymoney=" + weipaymoney + "]";
	}

	public BigDecimal getWeipaymoney() {
		return weipaymoney;
	}

	public void setWeipaymoney(BigDecimal weipaymoney) {
		this.weipaymoney = weipaymoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
    }

    public Integer getTypee() {
        return typee;
    }

    public void setTypee(Integer typee) {
        this.typee = typee;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    public Integer getPrevalue() {
        return prevalue;
    }

    public void setPrevalue(Integer prevalue) {
        this.prevalue = prevalue;
    }

    public Integer getCurvalue() {
        return curvalue;
    }

    public void setCurvalue(Integer curvalue) {
        this.curvalue = curvalue;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getBillmoney() {
        return billmoney;
    }

    public void setBillmoney(BigDecimal billmoney) {
        this.billmoney = billmoney;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public BigDecimal getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(BigDecimal usermoney) {
        this.usermoney = usermoney;
    }
}