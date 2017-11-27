package com.oristartech.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oristartech.pojo.Film;
import com.oristartech.pojo.Test;
import com.oristartech.service.FilmService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class FilmController {

	/*@Autowired
	private FilmService service;

	@ApiOperation(value="获取影片详细信息", notes="根据url的id来获取影片详细信息",response=Film.class)
    @ApiImplicitParam(name = "filmCode", value = "影片ID",required = true,dataType = "String")
	@RequestMapping(value = "/code/{filmCode}", method = RequestMethod.GET)
	@ResponseBody
	public Film query(@PathVariable String filmCode) {
		Film film = this.service.findByCode(filmCode);
		return film;

	}
	
	@ApiOperation(value="获取电影列表", notes="")
	@RequestMapping(value = "/list/first",method = RequestMethod.GET)
	@ResponseBody
	public List<Film> showInfo() {
		List<Film> list = this.service.findAll();
		return list;
	}
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public List<String> findFilms() {
		List<String> filmCodes = this.service.findByDate(new Date());
		return filmCodes;
	}*/
	
	@Value("${cup}")
	private String cup;
	
	@Autowired
	private Film film;
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public void fun(@RequestParam(name="data",required=false) String id,HttpServletRequest request) throws Exception{
		String parameter = request.getParameter("data");
		//request.setCharacterEncoding("json/application;charset=utf-8");
		/*String vv = film.getFilm_name();
		String vv2=new String(vv.getBytes("UTF-8"),"ISO-8859-1");*/
		
		Test test = JSON.parseObject(parameter, Test.class);
		System.out.println(test.getId());
		
	}

}
