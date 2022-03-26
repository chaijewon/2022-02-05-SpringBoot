package com.it.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.student.controller",
		"com.it.student.dao","com.it.student.entity"})
public class StudentJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentJpaProjectApplication.class, args);
	}

}
