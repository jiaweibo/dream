package com.oristartech.pojo;

import java.io.Serializable;

public class Version implements Serializable{

	//版本编码
	private String version_code;
	//版本名称
	private String version_name;
	public String getVersion_code() {
		return version_code;
	}
	public void setVersion_code(String version_code) {
		this.version_code = version_code;
	}
	public String getVersion_name() {
		return version_name;
	}
	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}
}
