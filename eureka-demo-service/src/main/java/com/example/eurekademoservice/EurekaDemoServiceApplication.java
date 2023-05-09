package com.example.eurekademoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDemoServiceApplication.class, args);
	}

}
