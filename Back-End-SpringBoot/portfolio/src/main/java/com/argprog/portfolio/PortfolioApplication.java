package com.argprog.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/person/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/education/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/language/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/project/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/residence/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/technology/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/api/workexperiencie/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
			}
		};
	}

}
