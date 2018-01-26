package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Controller
public class TestController {

	@Resource
	StudentRepo studentRepo;

	@RequestMapping(value = "/app/save", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Student> saveData(@RequestBody Student student) {
		studentRepo.saveStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> testRest() {
		return new ResponseEntity<String>("cool the controllerr is fine", HttpStatus.OK);
	}

}
