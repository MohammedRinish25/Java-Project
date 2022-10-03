package com.bikerental.util;

public class Queries {
	
	//public static final String CREATEQUERY="create table bike(bikeNumber VARCHAR(20),bikeName VARCHAR(20),brand VARCHAR(20),location VARCHAR(20),category VARCHAR(20),startTime TimeStamp,endTime TimeStamp,fare double)";
	public static final String INSERTQUERY="insert into bike(bikeNumber,bikeName,brand,location,category,startDate,endDate,startTime,endTime,fare)values(?,?,?,?,?,?,?,?,?,?)";
	public static final String DELETEQUERY="delete from bike where bikeNumber=?";
	public static final String QUERYBYID="select * from bike where bikeNumber=?";
	public static final String SELECTQUERY="select * from bike";
	public static final String UPDATEQUERY="update bike set fare=? where bikeNumber=?";
	public static final String CATEGORYQUERY="select * from bike where category=?";
    public static final String QUERYBYFARE="select * from bike where category=? and fare=?";
    public static final String QUERYBYTIMEANDLOCATION="select* from bike where startTime>=? and endTime<=? and location=?";
    public static final String QUERYBYTIMEANDCATEGORY="select* from bike where startTime>=? and endTime<=? and category=?";
    public static final String QUERYBYDURATION="select* from bike where startTime>=? and endTime<=?";
}
