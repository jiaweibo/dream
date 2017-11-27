package com.oristartech.pojo;

import java.io.Serializable;
import java.util.List;

public class Film1 implements Serializable{
    
	private String film_code;
	private String film_name;
	private Version1 version;
	private List<Language1> languages;
	public String getFilm_code() {
		return film_code;
	}
	public void setFilm_code(String film_code) {
		this.film_code = film_code;
	}
	public String getFilm_name() {
		return film_name;
	}
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}
	public Version1 getVersion() {
		return version;
	}
	public void setVersion(Version1 version) {
		this.version = version;
	}
	public List<Language1> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language1> languages) {
		this.languages = languages;
	}
	
	
}
