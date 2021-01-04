package com.project.uberBooking.controllers.dto;

import org.springframework.data.geo.Point;

import lombok.Data;

@Data
public class RideRequestDTO {
	Long rideId;
	Point startLatitudeLongitude; 
	Point endLatitudeLongitude; 
	String vehicleType;	
}
