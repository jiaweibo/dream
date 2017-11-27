package com.oristartech.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.oristartech.pojo.Film;

@Mapper
public interface FilmMapper {
   
	public Film findByCode(String filmCode);
	
	public List<Film> findAll();
	
	public List<Film> findByFilmCodes(List<String> filmCodes);
	
	public List<String> findByDate(Date date);
}
