package com.project.uberBooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.uberBooking.entities.Ride;

public interface RidesRepository extends CrudRepository<Ride, Long> {

	public Ride findByName(String name);

	/**
	 * Return the Iterable of Rides that the user has previously done
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select ride from Ride ride where ride.riderId=:riderId")
	public Iterable<Ride> findByUserId(@Param("riderId") String riderId);
	
	/**
	 * Return the Iterable of Rides that the driver has previously done
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select ride from Ride ride where ride.driverId=:driverId")
	public Iterable<Ride> findByDriverId(@Param("driverId") String driverId);

}
