package com.mh.mocom.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mh.mocom.dto.MemberDto;

@Controller
public class CharController {

	@Autowired
	SqlSession sqlsession;
	
	
	@RequestMapping(value = "/testjson", method = RequestMethod.GET)
	@ResponseBody
	public String testjson() {
		int[]myages= {5,40,30,25,15,3};
		return "[\r\n"
				+ "  {\"name\": \"Tom\", \"age\": 10 },\r\n"
				+ "  {\"name\": \"Franz\", \"age\": 12 },\r\n"
				+ "  {\"name\": \"Chris Calip\", \"age\": 36 },\r\n"
				+ "  {\"name\": \"Maria\", \"age\": 30 },\r\n"
				+ "  {\"name\": \"Fred\", \"age\": 50 },\r\n"
				+ "  {\"name\": \"R Stallman\", \"age\": 60 }\r\n"
				+ "]";
	}
	@RequestMapping(value = "/selectmember", method = RequestMethod.GET)
	@ResponseBody
	public String selectmemeber() {
		
		List<MemberDto> list = sqlsession.selectList("member.select");
		
		return new Gson().toJson(list);
	}
	
	
	@RequestMapping(value = "/gsonlib", method = RequestMethod.GET)
	@ResponseBody
	public String gsonlib() {
		Gson gson = new Gson();
		JsonObject jobj =  new JsonObject();
		jobj.addProperty("name", 10);
		jobj.addProperty("age", 10);
		
		
		
		String test = gson.toJson(jobj);
		return test;
	}
	@RequestMapping(value = "/gsonlib1", method = RequestMethod.GET)
	@ResponseBody
	public String gsonlib1() {
		Gson gson = new Gson();
		MemberDto dto =  new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		
		
		String test = gson.toJson(dto);
		return test;
	}
	@RequestMapping(value = "/gsonlib2", method = RequestMethod.GET)
	@ResponseBody
	public String gsonlib2() {
		Gson gson = new Gson();
		MemberDto dto =  new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		
		
		String test = gson.toJson(dto);
		
		MemberDto jsondto= gson.fromJson(test, MemberDto.class);
		System.out.println(jsondto);
		
				
		return test;
	}
	@RequestMapping(value = "/gsonlib3", method = RequestMethod.GET)
	@ResponseBody
	public String gsonlib3() {
		Gson gson = new Gson();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		
		
		MemberDto dto1 =  new MemberDto();
		dto1.setAge(10);
		dto1.setId("aa");
		dto1.setPw("pw");
		
		
		
		list.add(dto1);

		
		
		MemberDto dto2 =  new MemberDto();
		dto2.setAge(20);
		dto2.setId("aa");
		dto2.setPw("pw");
		
		
		
		list.add(dto2);
		
		
		String test = gson.toJson(list);
		
		
		
		return test;
	}
}
