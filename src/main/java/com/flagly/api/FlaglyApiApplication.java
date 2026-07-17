package com.flagly.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlaglyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlaglyApiApplication.class, args);
	}

}
