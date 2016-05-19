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
@RequestMapping("/nutaxi-services/{applicationName}")
public class AnotherSampleNutaxiEurekaClientAppApplication {

	@RequestMapping("hello")
	public String hello(@PathVariable String applicationName) {
		return "Hello " + applicationName + "!";
	}

	public static void main(String[] args) {
		SpringApplication.run(AnotherSampleNutaxiEurekaClientAppApplication.class, args);
	}

}
