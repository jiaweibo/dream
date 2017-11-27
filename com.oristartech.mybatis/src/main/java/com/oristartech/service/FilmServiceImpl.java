package com.oristartech.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oristartech.mapper.FilmMapper;
import com.oristartech.pojo.Film;
import com.oristartech.pojo.Film1;

@Service
public class FilmServiceImpl implements FilmService{
     
	@Autowired
	private FilmMapper mapper;
	

	@Override
	public Film findByCode(String filmCode) {
		 Film film = this.mapper.findByCode(filmCode);
		return film;
	}


	@Override
	public List<Film> findAll() {
		List<Film> list = this.mapper.findAll();
		return list;
	}


	@Override
	public List<Film> findByFilmCodes(List<String> filmCodes) {
		List<Film> films = this.mapper.findByFilmCodes(filmCodes);
		return films;
	}


	@Override
	public List<String> findByDate(Date date) {
		List<String> filmCodes = this.mapper.findByDate(date);
		return filmCodes;
	}
}
