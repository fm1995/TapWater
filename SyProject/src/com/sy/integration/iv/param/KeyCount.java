package com.sy.integration.iv.param;

public class KeyCount {
	private String key;
	private Object value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public KeyCount() {
	}

	public KeyCount(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
}
