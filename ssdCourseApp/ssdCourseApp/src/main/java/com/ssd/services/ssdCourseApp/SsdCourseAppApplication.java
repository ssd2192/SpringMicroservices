package com.ssd.services.ssdCourseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SsdCourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsdCourseAppApplication.class, args);
	}

}
