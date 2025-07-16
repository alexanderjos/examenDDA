package com.valverde.seriviceegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SeriviceegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriviceegistryApplication.class, args);
	}

}
