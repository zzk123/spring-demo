package com.example.eurekademoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EurekaDemoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDemoClientApplication.class, args);
	}

}
