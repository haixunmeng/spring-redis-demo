package com.lan.mvc.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	public String set(){
		String key = UUID.randomUUID().toString();
		redisTemplate.opsForValue().set(key, new Date().toString());
		return key;
	}

	@Override
	public String get(String key) {
		Object value = redisTemplate.boundValueOps(key).get();
		return (String)value;
	}
	
}
