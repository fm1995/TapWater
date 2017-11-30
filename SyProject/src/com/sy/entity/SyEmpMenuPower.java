package com.sy.entity;



public class SyEmpMenuPower {
    private Integer empmenupowerId;

    private Integer empId;

    private Integer menuId;
    
    private SyMenu syMenus;
  

	

	public SyMenu getSyMenus() {
		return syMenus;
	}

	public void setSyMenus(SyMenu syMenus) {
		this.syMenus = syMenus;
	}

	public Integer getEmpmenupowerId() {
        return empmenupowerId;
    }

    public void setEmpmenupowerId(Integer empmenupowerId) {
        this.empmenupowerId = empmenupowerId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}