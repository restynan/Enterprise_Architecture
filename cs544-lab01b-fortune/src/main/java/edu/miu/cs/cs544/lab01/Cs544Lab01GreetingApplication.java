package edu.miu.cs.cs544.lab01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaClient
@SpringBootApplication
public class Cs544Lab01GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs544Lab01GreetingApplication.class, args);
	}

}
