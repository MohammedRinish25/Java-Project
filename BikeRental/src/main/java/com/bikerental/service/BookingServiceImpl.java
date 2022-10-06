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
	 * @param startTime
	 * @param endTime
	 * @param category
	 * @return
	 */
	@Override
	public Bike booking(LocalDateTime startTime, LocalDateTime endTime, String category) {
		return bookingDao.booking(startTime, endTime, category);
	}

	/**
	 * @param bikeId
	 */
	@Override
	public void updateAvailability(String bikeNumber) {
		bookingDao.updateAvailability(bikeNumber);
		
	}
	

}
