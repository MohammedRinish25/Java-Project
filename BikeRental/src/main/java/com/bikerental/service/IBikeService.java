package com.bikerental.service;


import java.time.LocalDateTime;
import java.util.List;

import com.bikerental.exception.BikeNotFoundException;
import com.bikerental.exception.CategoryNotFoundException;
import com.bikerental.model.Bike;

public interface IBikeService {

	
	void addBike(Bike bike);
	int updateBike(String bikeNumber,double fare) throws BikeNotFoundException;
	Bike getById(String bikeNumber) throws BikeNotFoundException;
	int deleteBike(String bikeNumber) throws BikeNotFoundException;
	
	 List<Bike> getAllBikes() throws BikeNotFoundException;
	 List<Bike> getByCategory(String category) throws CategoryNotFoundException;
	 List<Bike> getByCategoryandFare(String category,double fare) throws CategoryNotFoundException;
	 List<Bike> getByDuration(LocalDateTime startTime,LocalDateTime endTime) throws BikeNotFoundException;
	 List<Bike> getByTimeAndLocation(LocalDateTime startTime,LocalDateTime endTime, String location) throws BikeNotFoundException;
	 List<Bike> getByTimeAndCategory(LocalDateTime startTime,LocalDateTime endTime, String category) throws CategoryNotFoundException;
}
