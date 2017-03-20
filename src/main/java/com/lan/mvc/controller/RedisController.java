package com.lan.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lan.mvc.service.RedisService;

@Controller
public class RedisController {
	
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public @ResponseBody String set(){
		return redisService.set();
	}
	
	@RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
	public @ResponseBody String get(@PathVariable String key){
		return redisService.get(key);
	}
}
