package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends JdkSerializationRedisSerializer implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("grade")
	private int grade;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
