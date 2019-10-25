package com.mavenmasters.digibooky.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mavenmasters.digibooky" )
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
