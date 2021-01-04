package com.project.uberBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//Disabling JPA and datasource until configured to allow application to run
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class UberBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberBookingApplication.class, args);
	}

}
