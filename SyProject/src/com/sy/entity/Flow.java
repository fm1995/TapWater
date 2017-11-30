package com.sy.entity;

public class Flow {
	private Integer id;
	private String stepName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	@Override
	public String toString() {
		return "Flow [id=" + id + ", stepName=" + stepName + "]";
	}
	
	public Flow(Integer id,String setpName){
		this.id=id;
		this.stepName = setpName;
	}
	public Flow(){
	}
}
