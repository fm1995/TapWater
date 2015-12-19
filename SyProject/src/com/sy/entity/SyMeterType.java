package com.sy.entity;

public class SyMeterType {
    private Integer metertypeId;

    private String meterTypeName;

    private Integer metertypeAperture;

    private Integer metertypeMaxValue;

    private Integer metertypeMinValue;

    private Integer metertypeLife;

    private String metertypeRemark;

    private Boolean metertypeDisabled;

    public Integer getMetertypeId() {
        return metertypeId;
    }

    public void setMetertypeId(Integer metertypeId) {
        this.metertypeId = metertypeId;
    }

    public String getMeterTypeName() {
        return meterTypeName;
    }

    public void setMeterTypeName(String meterTypeName) {
        this.meterTypeName = meterTypeName == null ? null : meterTypeName.trim();
    }

    public Integer getMetertypeAperture() {
        return metertypeAperture;
    }

    public void setMetertypeAperture(Integer metertypeAperture) {
        this.metertypeAperture = metertypeAperture;
    }

    public Integer getMetertypeMaxValue() {
        return metertypeMaxValue;
    }

    public void setMetertypeMaxValue(Integer metertypeMaxValue) {
        this.metertypeMaxValue = metertypeMaxValue;
    }

    public Integer getMetertypeMinValue() {
        return metertypeMinValue;
    }

    public void setMetertypeMinValue(Integer metertypeMinValue) {
        this.metertypeMinValue = metertypeMinValue;
    }

    public Integer getMetertypeLife() {
        return metertypeLife;
    }

    public void setMetertypeLife(Integer metertypeLife) {
        this.metertypeLife = metertypeLife;
    }

    public String getMetertypeRemark() {
        return metertypeRemark;
    }

    public void setMetertypeRemark(String metertypeRemark) {
        this.metertypeRemark = metertypeRemark == null ? null : metertypeRemark.trim();
    }

    public Boolean getMetertypeDisabled() {
        return metertypeDisabled;
    }

    public void setMetertypeDisabled(Boolean metertypeDisabled) {
        this.metertypeDisabled = metertypeDisabled;
    }
}