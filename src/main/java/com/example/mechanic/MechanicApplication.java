package com.example.mechanic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MechanicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MechanicApplication.class, args);
	}

}
