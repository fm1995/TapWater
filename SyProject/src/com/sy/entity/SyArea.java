package com.sy.entity;

public class SyArea {
    private Integer areaId;

    private String areaName;

    private String areaRemark;

    private Boolean areaDisabled;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaRemark() {
        return areaRemark;
    }

    public void setAreaRemark(String areaRemark) {
        this.areaRemark = areaRemark == null ? null : areaRemark.trim();
    }

    public Boolean getAreaDisabled() {
        return areaDisabled;
    }

    public void setAreaDisabled(Boolean areaDisabled) {
        this.areaDisabled = areaDisabled;
    }
}