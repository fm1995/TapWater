package com.sy.entity;

public class RdVolume {
    private Integer id;

    private String volumeName;

    private Integer areaId;

    private Integer orderIndex;

    private String remark;

    private Boolean disabled;
    
    //¼¶ÁªÊôÐÔ
    private SyArea syArea;

	public SyArea getSyArea() {
		return syArea;
	}

	public void setSyArea(SyArea syArea) {
		this.syArea = syArea;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName == null ? null : volumeName.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

	@Override
	public String toString() {
		return "RdVolume [id=" + id + ", volumeName=" + volumeName
				+ ", areaId=" + areaId + ", orderIndex=" + orderIndex
				+ ", remark=" + remark + ", disabled=" + disabled + "]";
	}
    
    
}