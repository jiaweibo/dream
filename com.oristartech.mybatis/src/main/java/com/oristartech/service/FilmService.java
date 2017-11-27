package com.oristartech.service;

import java.util.Date;
import java.util.List;

import com.oristartech.pojo.Film;

public interface FilmService {
	public Film findByCode(String filmCode);
	public List<Film> findAll();
	public List<Film> findByFilmCodes(List<String> filmCodes);
	public List<String> findByDate(Date date);
}
