package com.bikerental.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.bikerental.model.Bike;


public interface IBikeDao {
	
	void addBike(Bike bike);
	int updateBike(String bikeNumber,double fare);
	Bike findById(String bikeNumber);
	int deleteBike(String bikeNumber);
	
	 List<Bike> findAllBikes();
	 List<Bike> findByCategory(String category);
	 List<Bike> findByCategoryandFare(String category,double fare);
	 List<Bike> findByDuration(LocalDateTime startTime,LocalDateTime endTime);
	 List<Bike> findByTimeAndLocation(LocalDateTime startTime,LocalDateTime endTime, String location);
	 List<Bike> findByTimeAndCategory(LocalDateTime startTime,LocalDateTime endTime, String category);
	 

}
