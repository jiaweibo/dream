package com.oristartech.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Movie",description="影片")
@ConfigurationProperties(prefix = "film")
@Component
public class Film implements Serializable{
	// 影片编码
	@ApiModelProperty(value = "影片id")
	private String film_code;
	// 影片名称
	private String film_name;
	// 影片版本
	private Version filmVersion;

	// 影片语言
	private List<Language> filmLanguage;
	// 公映日期
	private String date_release;
	// 影片时长
	private Long film_time;

	// 影片分级
	private String film_level;
	// 影片类型
	private String film_type;
	// 导演
	private String director;

	private String film_off_date;
	// 主演
	private String cast;
	// 图片路径
	private String film_image;
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
	
	public Version getFilmVersion() {
		return filmVersion;
	}
	public void setFilmVersion(Version filmVersion) {
		this.filmVersion = filmVersion;
	}
	public List<Language> getFilmLanguage() {
		return filmLanguage;
	}
	public void setFilmLanguage(List<Language> filmLanguage) {
		this.filmLanguage = filmLanguage;
	}
	public String getDate_release() {
		return date_release;
	}
	public void setDate_release(String date_release) {
		this.date_release = date_release;
	}
	public Long getFilm_time() {
		return film_time;
	}
	public void setFilm_time(Long film_time) {
		this.film_time = film_time;
	}
	public String getFilm_level() {
		return film_level;
	}
	public void setFilm_level(String film_level) {
		this.film_level = film_level;
	}
	public String getFilm_type() {
		return film_type;
	}
	public void setFilm_type(String film_type) {
		this.film_type = film_type;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getFilm_off_date() {
		return film_off_date;
	}
	public void setFilm_off_date(String film_off_date) {
		this.film_off_date = film_off_date;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getFilm_image() {
		return film_image;
	}
	public void setFilm_image(String film_image) {
		this.film_image = film_image;
	}
}
