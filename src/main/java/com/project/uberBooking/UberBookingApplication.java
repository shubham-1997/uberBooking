package com.project.uberBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UberBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberBookingApplication.class, args);
	}

}
