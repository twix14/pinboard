package com.example.pinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PinboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinboardApplication.class, args);
	}

}
