package com.it.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.food.controller",
		     "com.it.food.dao","com.it.food.entity"})
public class FoodJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodJpaProjectApplication.class, args);
	}

}
