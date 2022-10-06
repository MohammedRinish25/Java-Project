/**
 * 
 */
package com.bikerental.model;

/**
 * @author MohammedRinishA
 *
 */
public class User {
	
	private Integer userId;
	private String name;
	private String username;
	private String password;
	private long mobileNumber;
	private String city;
	private String type;
	
	public User() {
		super();
	}
	public User(Integer userId, String name, String username, String password, long mobileNumber, String city,
			String type) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.type = type;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", city=" + city + ", type=" + type + "]";
	}
	
	
}
