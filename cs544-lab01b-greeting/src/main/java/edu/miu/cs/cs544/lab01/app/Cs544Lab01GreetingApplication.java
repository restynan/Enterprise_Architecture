package edu.miu.cs.cs544.lab01.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
public class Cs544Lab01GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs544Lab01GreetingApplication.class, args);
	}

}
