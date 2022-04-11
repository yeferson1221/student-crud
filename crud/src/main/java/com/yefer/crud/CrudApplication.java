package com.yefer.crud;

import com.yefer.crud.entity.Student;
import com.yefer.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void run(String... args) throws Exception {
		/*
		Student student = new Student("Yefer","Valencia","alejandro@gmail.com");
		studentRepository.save(student);

		Student student1 = new Student("Alejo","Garzon","yeferson@gmail.com");
		studentRepository.save(student1);list

		 */
	}
}
