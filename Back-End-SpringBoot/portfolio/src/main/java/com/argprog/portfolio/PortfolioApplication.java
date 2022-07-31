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
				registry.addMapping("/api/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/person/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/education/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/language/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/project/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/residence/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/technology/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
				registry.addMapping("/api/workexperiencie/**").allowedOrigins("https://portfolio-1d30e.web.app/").allowedMethods("*");
			}
		};
	}

}
