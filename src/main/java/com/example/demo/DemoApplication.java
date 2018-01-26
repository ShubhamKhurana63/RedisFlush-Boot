package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;

@SpringBootApplication
public class DemoApplication {
	
	
	
	
	
	

	public static void main(String[] args) {
		
		Jedis jedis=new Jedis("localhost", 6379);
		jedis.flushDB();
		jedis.flushAll();
		
		
		SpringApplication.run(DemoApplication.class, args);
	}
}
