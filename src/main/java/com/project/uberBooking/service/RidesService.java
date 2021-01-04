package com.project.uberBooking.service;

import com.project.uberBooking.controllers.dto.RideRequestDTO;
import com.project.uberBooking.entities.Ride;

public interface RidesService {

	Ride createRide(RideRequestDTO rideRequest);

	Ride cancelRide(RideRequestDTO rideRequestDTO);

}
