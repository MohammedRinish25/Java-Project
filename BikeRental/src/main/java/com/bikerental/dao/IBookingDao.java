/**
 * 
 */
package com.bikerental.dao;

import java.time.LocalDateTime;

import com.bikerental.model.Bike;

/**
 * @author MohammedRinishA
 *
 */
public interface IBookingDao {
	
	Bike booking(LocalDateTime startTime, LocalDateTime endTime,String category);
	
	void updateAvailability(String BikeNumber);

}
