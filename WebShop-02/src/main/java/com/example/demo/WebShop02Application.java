package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebShop02Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebShop02Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(WebShop02Application.class);
	}

}
