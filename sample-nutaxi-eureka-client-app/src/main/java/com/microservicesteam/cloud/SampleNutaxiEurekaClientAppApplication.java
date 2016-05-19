package com.microservicesteam.cloud;

import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@RequestMapping("/nutaxi-services/{applicationName}")
public class SampleNutaxiEurekaClientAppApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleNutaxiEurekaClientAppApplication.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(SampleNutaxiEurekaClientAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		discoveryClient.getInstances("another-sample-nutaxi-app").forEach((ServiceInstance serverInstance) -> {
			LOGGER.info("Service 'another-sample-nutaxi-app' is discovered: {}", reflectionToString(serverInstance));

			RestTemplate restTemplate = new RestTemplate();
			String url = serverInstance.getUri() + "/nutaxi-services/" + serverInstance.getServiceId().toLowerCase()
					+ "/hello";

			LOGGER.info("URL: {}", url);

			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			LOGGER.info("Response: {}", response.getBody());
		});

	}

}
