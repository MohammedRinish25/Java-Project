/**
 * 
 */
package com.bikerental.model;

import java.time.LocalDateTime;

/**
 * @author MohammedRinishA
 *
 */
public class Booking {

	
	private Integer bookingId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String category;
	public Booking() {
		super();
	}
	public Booking(Integer bookingId, LocalDateTime startTime, LocalDateTime endTime, String category) {
		super();
		this.bookingId = bookingId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.category = category;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", startTime=" + startTime + ", endTime=" + endTime + ", category="
				+ category + "]";
	}
	
	
	
}
