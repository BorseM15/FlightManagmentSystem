package com.example.passenger;

import org.springframework.boot.SpringApplication;import org.springframework.boot.SpringApplication.Running;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerApplication.class, args);
		System.out.println("passanger server Running...");
	}

}
