/**
 * 
 */
package com.bikerental.service;

import com.bikerental.exception.UserNotFoundException;
import com.bikerental.model.User;

/**
 * @author MohammedRinishA
 *
 */
public interface IUserService {
	
	String register(User user);
	User login(String userName,String password)throws UserNotFoundException;
	int changePassword(String userName,String password) throws UserNotFoundException;

}
