/**
 * 
 */
package com.bikerental.service;

import java.time.LocalDateTime;

import com.bikerental.model.Bike;

/**
 * @author MohammedRinishA
 *
 */
public interface IBookingService {

  Bike booking(LocalDateTime startTime, LocalDateTime endTime,String category);
	
	void updateAvailability(String bikeNumber);
}
