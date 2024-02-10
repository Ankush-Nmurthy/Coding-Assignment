package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CodingAssignmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CodingAssignmentApplication.class, args);
	}
	
	@Bean
	public RestTemplate provideRestTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
}
