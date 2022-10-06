package com.bikerental.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bikerental.model.Bike;

public class BikeMapper implements IRowMapper{

	@Override
	public List<Bike> mapRow(ResultSet resultSet) throws SQLException {
		List <Bike> bikes= new ArrayList<>();
		try {
			while(resultSet.next()) {
				 Bike bike =new Bike();
				 bike.setBikeId(resultSet.getInt(1));
				 bike.setBikeNumber(resultSet.getString(2));
				 bike.setBikeName(resultSet.getString(3));
				 bike.setBrand(resultSet.getString(4));
				 bike.setLocation(resultSet.getString(5));
				 bike.setCategory(resultSet.getString(6));
				 bike.setStartDate(resultSet.getDate(7).toLocalDate());
				 bike.setEndDate(resultSet.getDate(8).toLocalDate());
				 bike.setStartTime(resultSet.getTimestamp(9).toLocalDateTime());
				 bike.setEndTime( resultSet.getTimestamp(10).toLocalDateTime());
				 bike.setFare(resultSet.getDouble(11));	 
				 bike.setAvailability(resultSet.getBoolean(12));
				
				 bikes.add(bike);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  return bikes;
	}

}
