/**
 * 
 */
package com.bikerental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.bikerental.model.Bike;
import com.bikerental.util.DbConnection;
import com.bikerental.util.Queries;

/**
 * @author MohammedRinishA
 *
 */
public class BookingDaoImpl  implements IBookingDao{

	/**
	 * @param startTime
	 * @param endTime
	 * @param category
	 * @return
	 */
	@Override
	public Bike booking(LocalDateTime startTime, LocalDateTime endTime, String category) {
		
		PreparedStatement statement=null;
	    Bike bike=new Bike();
		ResultSet resultSet=null;
     try {
			
	        Connection connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QUERYFORBOOKING);
			LocalDateTime start = startTime;
	        Timestamp timeStamp = Timestamp.valueOf(start);
	        statement.setTimestamp(1, timeStamp);
	        
	        LocalDateTime end = endTime;
	        Timestamp timeendStamp = Timestamp.valueOf(end);
			statement.setTimestamp(2, timeendStamp);
			 
			statement.setString(3, category);
			resultSet= statement.executeQuery();
			if(!resultSet.next()) {
				return null;
			}else {
			 
			 
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
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (statement != null)
					statement.close();
				if(resultSet !=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}
		
		
		return bike;
	}

		
	

	/**
	 * @param bikeId
	 */
	@Override
	public void updateAvailability(String bikeNumber) {
		PreparedStatement statement=null;
		
		try {
			Connection connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QUERYFORAVAILABILIY);
			statement.setString(1,bikeNumber);
			
			 
		statement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}
		
		
		

	}
		
}
	
		


