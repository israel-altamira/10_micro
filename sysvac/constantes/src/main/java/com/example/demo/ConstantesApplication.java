package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// @EnableCircuitBreaker // hystrix
@EnableEurekaClient
@SpringBootApplication
public class ConstantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstantesApplication.class, args);
	}

}
