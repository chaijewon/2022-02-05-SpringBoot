package com.it.seoul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 클래스 메모리 할당 (스프링 => 클래스 관리) => Front (데이터 관리)
// <context-component-scan base-package="">
@ComponentScan(basePackages = {"com.it.seoul.controller",
		    "com.it.seoul.dao","com.it.seoul.service"})
public class SeoulLocationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeoulLocationProjectApplication.class, args);
	}

}
