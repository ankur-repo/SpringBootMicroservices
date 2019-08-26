package com.fis.ankur.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //Optional
public class RatingDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

}
