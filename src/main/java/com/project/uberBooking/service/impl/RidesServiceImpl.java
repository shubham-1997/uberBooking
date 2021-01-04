package com.project.uberBooking.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.project.uberBooking.controllers.dto.RideEstimateDTO;
import com.project.uberBooking.controllers.dto.RideRequestDTO;
import com.project.uberBooking.entities.Ride;
import com.project.uberBooking.exceptions.InvalidRequestException;
import com.project.uberBooking.models.RideStatus;
import com.project.uberBooking.repository.RidesRepository;
import com.project.uberBooking.service.RidesService;

@Service
public class RidesServiceImpl implements RidesService{
	
	@Autowired
	RidesRepository ridesRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(RidesService.class);
	
	/**
	 * 
	 */
	@Override
	public Ride createRide(RideRequestDTO rideRequest) {
		
		//oauth check/security check to come here 
		
		Ride newRide = new Ride();
		//assign other values further which doesn't come from UI request
		newRide.setCreatedDate(new Date());	
		
		ridesRepo.save(newRide);
		return newRide;
	}
	
	@Override
	public Ride cancelRide(RideRequestDTO rideRequestDTO) {
		
		Optional<Ride> optRide = ridesRepo.findById(rideRequestDTO.getRideId());
		optRide.orElseThrow(() -> new EntityNotFoundException("Ride with given id not found"));
		
		optRide.get().setRideStatus(RideStatus.CANCELLED);
		ridesRepo.save(optRide.get());
		
		return optRide.get();
	}

	public RideEstimateDTO getRideEstimate(RideRequestDTO rideRequest) throws InvalidRequestException {
		if(validateServiceableLocation(rideRequest.getStartLatitudeLongitude())) {
			logger.error("Exception while getting ride estimate");
			throw new InvalidRequestException("Selected location is unserviceable");
		}
		
		RideEstimateDTO currentEstimate =  new RideEstimateDTO();
		Long amount = calculateEstimatedAmount(rideRequest.getEndLatitudeLongitude(),rideRequest.getStartLatitudeLongitude());
		String time = calculateEstimatedTime(rideRequest.getEndLatitudeLongitude(),rideRequest.getStartLatitudeLongitude(),rideRequest.getVehicleType());
		currentEstimate.setEstimatedAmount(amount);
		currentEstimate.setEstimatedTime(time);
		return currentEstimate;
		
	}
	
	public void acceptRide() {
		
	}
	
	private Long calculateEstimatedAmount(Point start, Point end) {
		//Dummy method for mathematical calculation of estimate
		return 100L;
	}
	
	private String calculateEstimatedTime(Point start, Point end,String vehicleType) {
		//Dummy method for mathematical calculation of estimate
		return "";
	}
	
	private boolean validateServiceableLocation(Point currentLocation) {
		//Dummy method to validate whether requested location is serviceable
		return true;
	}
}
