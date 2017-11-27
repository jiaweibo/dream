package com.oristartech.pojo;

import java.io.Serializable;

public class Version1 implements Serializable{

	private String v_code;
	private String v_name;
	public String getV_code() {
		return v_code;
	}
	public void setV_code(String v_code) {
		this.v_code = v_code;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
}
