package com.sy.entity;

public class BeFormula {
    private Integer id;

    private Integer orderUserId;

    private String waterTypeCode;

    private String allotText;

    private Integer allotType;

    private Integer allotValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getWaterTypeCode() {
        return waterTypeCode;
    }

    public void setWaterTypeCode(String waterTypeCode) {
        this.waterTypeCode = waterTypeCode == null ? null : waterTypeCode.trim();
    }

    public String getAllotText() {
        return allotText;
    }

    public void setAllotText(String allotText) {
        this.allotText = allotText == null ? null : allotText.trim();
    }

    public Integer getAllotType() {
        return allotType;
    }

    public void setAllotType(Integer allotType) {
        this.allotType = allotType;
    }

    public Integer getAllotValue() {
        return allotValue;
    }

    public void setAllotValue(Integer allotValue) {
        this.allotValue = allotValue;
    }
}