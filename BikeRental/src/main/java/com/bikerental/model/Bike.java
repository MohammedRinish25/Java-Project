package com.bikerental.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Bike {
	
	private Integer bikeId;
	private String bikeNumber;
	private String bikeName;
	private String brand;
	private String location;
	private String category;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fare;
	private boolean availability;
	
	public Bike() {
		super();
	}
	
	public Bike(Integer bikeId, String bikeNumber, String bikeName, String brand, String location, String category,
			boolean availability, LocalDate startDate, LocalDate endDate, LocalDateTime startTime,
			LocalDateTime endTime, double fare) {
		super();
		this.bikeId = bikeId;
		this.bikeNumber = bikeNumber;
		this.bikeName = bikeName;
		this.brand = brand;
		this.location = location;
		this.category = category;
		this.availability = availability;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fare = fare;
	}
	
	public Bike(String bikeNumber, String bikeName, String brand, String location, String category, LocalDate startDate,
			LocalDate endDate, LocalDateTime startTime, LocalDateTime endTime, double fare) {
		super();
		this.bikeNumber = bikeNumber;
		this.bikeName = bikeName;
		this.brand = brand;
		this.location = location;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fare = fare;
	}
	
	public Integer getBikeId() {
		return bikeId;
	}
	public void setBikeId(Integer bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeNumber() {
		return bikeNumber;
	}
	public void setBikeNumber(String bikeNumber) {
		this.bikeNumber = bikeNumber;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bikeNumber=" + bikeNumber + ", bikeName=" + bikeName + ", brand=" + brand
				+ ", location=" + location + ", category=" + category + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", fare=" + fare + ", availability="
				+ availability + "]";
	}
	
	
	
	

}
