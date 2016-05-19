package com.microservicesteam.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@EnableFeignClients
public class SampleNutaxiEurekaClientApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleNutaxiEurekaClientApplication.class);

	@Autowired
	private AnotherSampleNutaxiAppClient anotherSampleNutaxiAppClient;

	public static void main(String[] args) {
		SpringApplication.run(SampleNutaxiEurekaClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Response: {}", anotherSampleNutaxiAppClient.hello("Zoli"));
	}

	@FeignClient("another-sample-nutaxi-app")
	interface AnotherSampleNutaxiAppClient {
		@RequestMapping("/hello/{subject}")
		String hello(@PathVariable("subject") String subject);
	}
}
