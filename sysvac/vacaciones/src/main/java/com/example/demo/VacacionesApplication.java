package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
// @RibbonClient(name = "servicio-empleados")
@EnableFeignClients
@SpringBootApplication
public class VacacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacacionesApplication.class, args);
	}

}
