package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ProteinAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProteinAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Your code to execute after the application context is loaded
		System.out.println("Application started successfully!");
	}
}
