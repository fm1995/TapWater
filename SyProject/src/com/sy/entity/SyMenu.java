package com.sy.entity;

public class SyMenu {
    private Integer menuId;

    private String menuName;

    private Integer menuParent;

    private String menuUrl;

    private String menuOnClick;

    private String menuIcon;

    private Integer menuOrderIndex;

    private Integer flowId;

    private Boolean menuDisabled;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(Integer menuParent) {
        this.menuParent = menuParent;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuOnClick() {
        return menuOnClick;
    }

    public void setMenuOnClick(String menuOnClick) {
        this.menuOnClick = menuOnClick == null ? null : menuOnClick.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Integer getMenuOrderIndex() {
        return menuOrderIndex;
    }

    public void setMenuOrderIndex(Integer menuOrderIndex) {
        this.menuOrderIndex = menuOrderIndex;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Boolean getMenuDisabled() {
        return menuDisabled;
    }

    public void setMenuDisabled(Boolean menuDisabled) {
        this.menuDisabled = menuDisabled;
    }
}