package com.bikerental.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bikerental.exception.BikeNotFoundException;
import com.bikerental.model.Bike;

public interface IBikeService {

	
	void addBike(Bike bike);
	int updateBike(String bikeNumber,double fare);
	Bike getById(String bikeNumber);
	int deleteBike(String bikeNumber);
	
	 List<Bike> getAllBikes() throws BikeNotFoundException;
	 List<Bike> getByCategory(String category);
	 List<Bike> getByCategoryandFare(String category,double fare);
	 List<Bike> getByDuration(LocalDateTime startTime,LocalDateTime endTime);
	 List<Bike> getByTimeAndLocation(LocalDateTime startTime,LocalDateTime endTime, String location);
	 List<Bike> getByTimeAndCategory(LocalDateTime startTime,LocalDateTime endTime, String category);
}
