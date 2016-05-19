package com.microservicesteam.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class AnotherSampleNutaxiEurekaClientApplication {

	@RequestMapping("/hello/{subject}")
	public String hello(@PathVariable String subject) {
		return "Hello " + subject + "!";
	}

	public static void main(String[] args) {
		SpringApplication.run(AnotherSampleNutaxiEurekaClientApplication.class, args);
	}

}
