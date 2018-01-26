package com.example.demo.repo;

import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository(value = "studentRepo")
public class StudentRepo {

	public StudentRepo() {

	}

	private static final String KEY = "Student";

	private RedisTemplate<String, Student> redisTemplate;
	private HashOperations hashOps;

	@Autowired
	private StudentRepo(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOps = redisTemplate.opsForHash();
	}

	public void saveStudent(Student student) {

		System.out.println("=====================enetring the redis save================");

		// double rand = (Integer)Math.random() * 1000 + 1;
		Random rand = new Random();
		int n = rand.nextInt(50) + 1;
		System.out.println("random numbber is" + rand);
		hashOps.put(KEY+n, student.getId(), student);
	}

	public void updateStudent(Student student) {
		hashOps.put(KEY, student.getId(), student);
	
	}

	public Student findStudent(String id) {
		return (Student) hashOps.get(KEY, id);
	}

	public Map<Object, Object> findAllStudents() {
		return hashOps.entries(KEY);
	}

	public void deleteStudent(String id) {
		hashOps.delete(KEY, id);
	}

}
