package com.project.uberBooking.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.uberBooking.controllers.dto.RideRequestDTO;
import com.project.uberBooking.entities.Ride;
import com.project.uberBooking.exceptions.InvalidRequestException;
import com.project.uberBooking.service.RidesService;

@RestController
@RequestMapping("auth/consumer")
public class UsersController {

	@Autowired
	RidesService rideService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
	
	private static final String MISSING_LOCATION = "Start Location not present";
	private static final String MISSING_ID = "Ride Id is missing, required for cancelling a ride";

	@PostMapping("/bookRide")
	public Ride createDataCube(@RequestBody RideRequestDTO rideRequest)
			throws InvalidRequestException {

		if (rideRequest.getStartLatitudeLongitude()==null) {
			throw new InvalidRequestException(MISSING_LOCATION);
		}
		
		final Ride rideObject = rideService.createRide(rideRequest);		
		return rideObject;
	}
	
	@PutMapping("/bookRide")
	public Ride cancelDataCube(@RequestBody RideRequestDTO rideRequest)
			throws InvalidRequestException {

		if (rideRequest.getRideId()==null) {
			throw new InvalidRequestException(MISSING_ID);
		}
		
		final Ride rideObject = rideService.cancelRide(rideRequest);		
		return rideObject;
	}

	
}
