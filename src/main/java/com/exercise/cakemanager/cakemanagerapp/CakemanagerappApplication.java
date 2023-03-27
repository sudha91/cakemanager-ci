package com.exercise.cakemanager.cakemanagerapp;

import com.exercise.cakemanager.cakemanagerapp.service.CakeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CakemanagerappApplication {


	@Bean
	public CommandLineRunner commandLineRunner(CakeService service) {
		return runner -> service.save();
	}

	public static void main(String[] args) {
		SpringApplication.run(CakemanagerappApplication.class, args);
	}

}
