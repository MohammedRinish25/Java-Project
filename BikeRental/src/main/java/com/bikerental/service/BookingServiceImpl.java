/**
 * 
 */
package com.bikerental.service;

import java.time.LocalDateTime;

import com.bikerental.dao.IBookingDao;
import com.bikerental.dao.BookingDaoImpl;
import com.bikerental.model.Bike;

/**
 * @author MohammedRinishA
 *
 */
public class BookingServiceImpl implements IBookingService{

	IBookingDao bookingDao=new BookingDaoImpl();
	/**
	 * @param startTime search based on user start time
	 * @param endTime search based on user end time
	 * @param category search based on the category
	 * @return the booking result if bike is available
	 */
	@Override
	public Bike booking(LocalDateTime startTime, LocalDateTime endTime, String category) {
		return bookingDao.booking(startTime, endTime, category);
	}

	/**
	 * @param bikeNumber update the bikeNumber
	 */
	@Override
	public void updateAvailability(String bikeNumber) {
		bookingDao.updateAvailability(bikeNumber);
		
	}
	

}
