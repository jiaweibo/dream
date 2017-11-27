package com.oristartech.pojo;

import java.io.Serializable;

public class Language implements Serializable{
   
	//语言编码
	private String language_code;
	//语言名称
	private String language_name;
	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}
	public String getLanguage_name() {
		return language_name;
	}
	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}
	
}
