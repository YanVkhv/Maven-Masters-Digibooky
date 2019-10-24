package com.mavenmasters.digibooky.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner demo() {
//		return (args) -> {
//			System.out.println("test");
//
//		};
//
//	}
}
