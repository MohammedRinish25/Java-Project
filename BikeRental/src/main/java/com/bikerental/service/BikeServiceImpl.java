package com.bikerental.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.bikerental.dao.BikeDaoImpl;
import com.bikerental.dao.IBikeDao;
import com.bikerental.exception.BikeNotFoundException;
import com.bikerental.exception.CategoryNotFoundException;
import com.bikerental.model.Bike;



public class BikeServiceImpl implements IBikeService {

	IBikeDao bikeRental=new BikeDaoImpl();
	@Override
	public void addBike(Bike bike) {
		
		bikeRental.addBike(bike);
		
	}

	@Override
	public int updateBike(String bikeNumber, double fare) throws BikeNotFoundException{
		
		int result=bikeRental.updateBike(bikeNumber, fare);
		if(result==0) 
			throw new BikeNotFoundException("No Bikes found");
		
		else
			return result;
	}

	@Override
	public Bike getById(String bikeNumber) throws BikeNotFoundException {
		Bike bike=bikeRental.findById(bikeNumber);
		if(bike==null)
			 throw new BikeNotFoundException("No Bike Number found");
		else
		   return bike;
	}

	@Override
	public int deleteBike(String bikeNumber) throws BikeNotFoundException{
		int result=bikeRental.deleteBike(bikeNumber);
		
		if(result==0)
			throw new BikeNotFoundException("Enter correct bike Number ");
		else
			return result;
		
		
	}

	@Override
	public List<Bike> getAllBikes() throws BikeNotFoundException {
		List<Bike> bikes=bikeRental.findAllBikes();
		if(bikes.isEmpty()) {
			throw new BikeNotFoundException("No bikes Found");
		}
		return bikes
		.stream()
		.sorted( (bike1,bike2)-> ( bike1.getBikeName() ).compareTo (bike2.getBikeName() ) )
		.collect(Collectors.toList());
	}

	@Override
	public List<Bike> getByCategory(String category) throws BikeNotFoundException{
		List<Bike> bikes=bikeRental.findByCategory(category);
		if(bikes.isEmpty()) {
			throw new BikeNotFoundException("No bike category found");
		}
		return bikes.stream()
				.sorted( (bike1,bike2)-> ( bike1.getBikeName() ).compareTo (bike2.getBikeName()) )
				.collect(Collectors.toList());
	}

	@Override
	public List<Bike> getByCategoryandFare(String category, double fare) throws CategoryNotFoundException{
		List<Bike> bikes=bikeRental.findByCategoryandFare(category,fare);
		if(bikes.isEmpty()) {
			throw new CategoryNotFoundException("No Bikes found based on category and fare");
		}
		return bikes.stream()
				.sorted((bike1,bike2)-> ((Double)bike1.getFare() ).compareTo ((Double)bike2.getFare() ) )
				.collect(Collectors.toList());
	}

	@Override
	public List<Bike> getByDuration(LocalDateTime startTime, LocalDateTime endTime) throws BikeNotFoundException{
		
		List<Bike> bikes=bikeRental.findByDuration(startTime,endTime);
		if(bikes.isEmpty())
			throw new BikeNotFoundException ("No bikes found based on your timings and location");
		return bikes .stream()
				.sorted( (bike1,bike2)-> ( bike1.getBikeName() ).compareTo (bike2.getBikeName()) )
				.collect(Collectors.toList());
	}

	@Override
	public List<Bike> getByTimeAndLocation(LocalDateTime startTime, LocalDateTime endTime, String location)throws BikeNotFoundException {
		List<Bike> bikes=bikeRental.findByTimeAndLocation(startTime,endTime,location);
		if(bikes.isEmpty())
			throw new BikeNotFoundException ("No bikes found based on your timings and location");
		return bikes .stream()
				.sorted( (bike1,bike2)-> ( bike1.getBikeName() ).compareTo (bike2.getBikeName()) )
				.collect(Collectors.toList());
		
	}

	@Override
	public List<Bike> getByTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, String category) throws CategoryNotFoundException {
		List<Bike> bikes=bikeRental.findByTimeAndCategory(startTime,endTime,category);
		if(bikes.isEmpty())
			throw new CategoryNotFoundException ("No bikes found based on your timings and Category");
		return bikes .stream()
				.sorted( (bike1,bike2)-> ( bike1.getBikeName() ).compareTo (bike2.getBikeName()) )
				.collect(Collectors.toList());
		
		
	}

	
}
