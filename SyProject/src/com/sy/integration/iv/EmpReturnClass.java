package com.sy.integration.iv;

public class EmpReturnClass {

	/**发票管理
	 * 
	 * 收费人员发票查询封装类
	 */
	private Integer ivAllCount, ivUsedCount, ivInvalidCount, ivArchivedCount,
			noUsedCount, noArchivedCount;
	private String empName;

	public Integer getIvAllCount() {
		return ivAllCount;
	}

	public void setIvAllCount(Integer ivAllCount) {
		this.ivAllCount = ivAllCount;
	}

	public Integer getIvUsedCount() {
		return ivUsedCount;
	}

	public void setIvUsedCount(Integer ivUsedCount) {
		this.ivUsedCount = ivUsedCount;
	}

	public Integer getIvInvalidCount() {
		return ivInvalidCount;
	}

	public void setIvInvalidCount(Integer ivInvalidCount) {
		this.ivInvalidCount = ivInvalidCount;
	}

	public Integer getIvArchivedCount() {
		return ivArchivedCount;
	}

	public void setIvArchivedCount(Integer ivArchivedCount) {
		this.ivArchivedCount = ivArchivedCount;
	}

	public Integer getNoUsedCount() {
		return noUsedCount;
	}

	public void setNoUsedCount(Integer noUsedCount) {
		this.noUsedCount = noUsedCount;
	}

	public Integer getNoArchivedCount() {
		return noArchivedCount;
	}

	public void setNoArchivedCount(Integer noArchivedCount) {
		this.noArchivedCount = noArchivedCount;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmpReturnClass [ivAllCount=" + ivAllCount + ", ivUsedCount="
				+ ivUsedCount + ", ivInvalidCount=" + ivInvalidCount
				+ ", ivArchivedCount=" + ivArchivedCount + ", noUsedCount="
				+ noUsedCount + ", noArchivedCount=" + noArchivedCount
				+ ", empName=" + empName + "]";
	}

}