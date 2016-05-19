package com.microservicesteam.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NutaxiEurekaServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutaxiEurekaServerAppApplication.class, args);
	}
}
