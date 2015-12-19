package com.sy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PyBalance {
    private Integer id;

    private String userno;

    private Date balancedate;

    private BigDecimal balancemoney;

    private String billno;

    private BigDecimal billrealmoney1;

    private BigDecimal billrealmoney2;

    private String payno;

    private BigDecimal payusemoney1;

    private BigDecimal payusemoney2;

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

    public Date getBalancedate() {
        return balancedate;
    }

    public void setBalancedate(Date balancedate) {
        this.balancedate = balancedate;
    }

    public BigDecimal getBalancemoney() {
        return balancemoney;
    }

    public void setBalancemoney(BigDecimal balancemoney) {
        this.balancemoney = balancemoney;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public BigDecimal getBillrealmoney1() {
        return billrealmoney1;
    }

    public void setBillrealmoney1(BigDecimal billrealmoney1) {
        this.billrealmoney1 = billrealmoney1;
    }

    public BigDecimal getBillrealmoney2() {
        return billrealmoney2;
    }

    public void setBillrealmoney2(BigDecimal billrealmoney2) {
        this.billrealmoney2 = billrealmoney2;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno == null ? null : payno.trim();
    }

    public BigDecimal getPayusemoney1() {
        return payusemoney1;
    }

    public void setPayusemoney1(BigDecimal payusemoney1) {
        this.payusemoney1 = payusemoney1;
    }

    public BigDecimal getPayusemoney2() {
        return payusemoney2;
    }

    public void setPayusemoney2(BigDecimal payusemoney2) {
        this.payusemoney2 = payusemoney2;
    }
}