/**
 * 
 */
package com.bikerental.dao;

import com.bikerental.model.User;

/**
 * @author MohammedRinishA
 *
 */
public interface IUserDao {
	
	String addUser(User user);
	User findByUserName(String userName,String password);
	int changePassword(String userName,String password);

}
