package com.bikerental.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bikerental.model.Bike;
import com.bikerental.util.BikeMapper;
import com.bikerental.util.DbConnection;
import com.bikerental.util.IRowMapper;
import com.bikerental.util.Queries;




public class BikeDaoImpl implements IBikeDao{

	IRowMapper rowMapper=new BikeMapper(); 
	
	@Override
	public void addBike(Bike bike) {
		PreparedStatement statement=null;
		Date startDate=Date.valueOf(bike.getStartDate());
		Date endDate=Date.valueOf(bike.getEndDate());
		
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, bike.getBikeNumber());
			statement.setString(2,bike.getBikeName());
			statement.setString(3,bike.getBrand());
			statement.setString(4,bike.getLocation());
			statement.setString(5,bike.getCategory() );
			statement.setDate(6,startDate);
			statement.setDate(7, endDate);
			statement.setTimestamp(8, Timestamp.valueOf(bike.getStartTime()));
			statement.setTimestamp(9,Timestamp.valueOf(bike.getEndTime()) );
			statement.setDouble(10,bike.getFare());
			statement.setBoolean(11, true);
			statement.execute();

		}catch(SQLException e) {
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

	@Override
	public int updateBike(String bikeNumber, double fare) {
		PreparedStatement statement=null;
		int result=0;
		try {
			Connection connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1,fare);
			statement.setString(2, bikeNumber);
			 
			result =statement.executeUpdate();
			
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
		
		return result;
		

	}

	@Override
	public Bike findById(String bikeNumber) {
		
		PreparedStatement statement=null;
	    Bike bike=new Bike();
		ResultSet resultSet=null;
     try {
			
	        Connection connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QUERYBYID);
			statement.setString(1, bikeNumber);
			resultSet= statement.executeQuery();
			 
			while(resultSet.next()) {
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

	@Override
	public int deleteBike(String bikeNumber) {
		PreparedStatement statement=null;
		int result=0;
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.DELETEQUERY);
			statement.setString(1, bikeNumber);
			result=statement.executeUpdate();


		}catch(SQLException e) {
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

		return result;	
	}

	@Override
	public List<Bike> findAllBikes() {
		List<Bike> bikes=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		  
		try {
		        Connection connection = DbConnection.openConnection();
				statement = connection.prepareStatement(Queries.SELECTQUERY);
				
				 resultSet= statement.executeQuery();
				
				bikes=rowMapper.mapRow(resultSet);
				

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				try {
					if (statement != null)
						statement.close();
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbConnection.closeConnection();
			}
			
			
			return bikes;
		}

		
	

	@Override
	public List<Bike> findByCategory(String category) {
		List<Bike> bikes=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		  try {
				
		        Connection connection = DbConnection.openConnection();
				statement = connection.prepareStatement(Queries.CATEGORYQUERY);
				statement.setString(1, category);
				 resultSet= statement.executeQuery();
				 bikes=rowMapper.mapRow(resultSet);
				

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
			
			
			return bikes;
		}

		
	

	@Override
	public List<Bike> findByCategoryandFare(String category, double fare) {
		List<Bike> bikes=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		  try {
				
		        Connection connection = DbConnection.openConnection();
				statement = connection.prepareStatement(Queries.QUERYBYFARE);
				statement.setString(1, category);
				statement.setDouble(2, fare);
				resultSet= statement.executeQuery();
				
				bikes=rowMapper.mapRow(resultSet);
				

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
			
			
			return bikes;
		
		
	}

	@Override
	public List<Bike> findByDuration(LocalDateTime startTime, LocalDateTime endTime) {
		
     List<Bike> bikes=new ArrayList<>();
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	try {
		Connection connection=DbConnection.openConnection();
		statement=connection.prepareStatement(Queries.QUERYBYDURATION);
		
		LocalDateTime start = startTime;
        Timestamp timeStamp = Timestamp.valueOf(start);
        statement.setTimestamp(1, timeStamp);
        
        LocalDateTime end = endTime;
        Timestamp timeendStamp = Timestamp.valueOf(end);
		statement.setTimestamp(2, timeendStamp);
		 
		 
		 
		 resultSet= statement.executeQuery();
			
		 bikes=rowMapper.mapRow(resultSet);

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
		
					return bikes;
	
	
}

	@Override
	public List<Bike> findByTimeAndLocation(LocalDateTime startTime, LocalDateTime endTime, String location) {
		List<Bike> bikes=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.QUERYBYTIMEANDLOCATION);
			
			LocalDateTime start = startTime;
	        Timestamp timeStamp = Timestamp.valueOf(start);
	        statement.setTimestamp(1, timeStamp);
	        
	        LocalDateTime end = endTime;
	        Timestamp timeendStamp = Timestamp.valueOf(end);
			statement.setTimestamp(2, timeendStamp);
			 
			 statement.setString(3,location);
			 
			 resultSet = statement.executeQuery();
				
			 bikes=rowMapper.mapRow(resultSet);
				

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
			
						return bikes;
		
		
	}
	

	@Override
	public List<Bike> findByTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, String category) {
		
		List<Bike> bikes=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.QUERYBYTIMEANDCATEGORY);
			
			LocalDateTime start = startTime;
	        Timestamp timeStamp = Timestamp.valueOf(start);
	        statement.setTimestamp(1, timeStamp);
	        
	        LocalDateTime end = endTime;
	        Timestamp timeendStamp = Timestamp.valueOf(end);
			statement.setTimestamp(2, timeendStamp);
			 
			 statement.setString(3,category);
			 
			  resultSet= statement.executeQuery();
				
			  bikes=rowMapper.mapRow(resultSet);
				

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
			
						return bikes;
		
		
	}
	
	}




