/**
 * 
 */
package com.bikerental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bikerental.model.User;
import com.bikerental.util.DbConnection;
import com.bikerental.util.PasswordGenerator;
import com.bikerental.util.Queries;

/**
 * @author MohammedRinishA
 *
 */
public class UserDaoImpl implements IUserDao{

	@Override
	public String addUser(User user) {
		PreparedStatement statement=null;
		String password=PasswordGenerator.randomPassword();
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.QUERYADDUSER);
			statement.setString(1, user.getName());
			statement.setString(2,user.getUsername());
			statement.setString(3,password);
			statement.setLong(4, user.getMobileNumber());
			statement.setString(5, user.getCity());
			statement.setString(6, user.getType());
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
		return password;
	}

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	@Override
	public User findByUserName(String userName, String password) {
		User user=null;
		PreparedStatement statement=null;
		try {
			Connection connection=DbConnection.openConnection();
		    statement= connection.prepareStatement(Queries.QUERYLOGIN);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet=statement.executeQuery();
			user=new User();
			while(resultSet.next()) {
				user.setUserId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				user.setMobileNumber(resultSet.getLong(5));
				user.setCity(resultSet.getString(6));
				user.setType(resultSet.getString(7));
				
			}
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
		
		return user;
	}

	@Override
	public int changePassword(String userName,String password) {
		PreparedStatement statement=null;
		int result=0;
		try {
			Connection connection=DbConnection.openConnection();
			statement=connection.prepareStatement(Queries.QUERYCHANGEPASSWORD);
			statement.setString(1, userName);
			statement.setString(2, password);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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


}
