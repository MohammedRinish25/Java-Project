/**
 * 
 */
package com.bikerental.service;

import com.bikerental.dao.IUserDao;
import com.bikerental.dao.UserDaoImpl;
import com.bikerental.exception.UserNotFoundException;
import com.bikerental.model.User;

/**
 * @author MohammedRinishA
 *
 */
public class UserServiceImpl implements IUserService{
	
	IUserDao userDao=new UserDaoImpl();
	/**
	 * @param add user to the table
	 * @return added user
	 */
	@Override
	public String register(User user) {
		return userDao.addUser(user);
	}

	/**
	 * @param userName to search based on name
	 * @param password to search based on password
	 * @return the user or else throw exception
	 */
	@Override
	public User login(String userName, String password) throws UserNotFoundException{
		User user=null;
		user=userDao.findByUserName(userName, password);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("Invalid Credential");
		}
	}

	/**
	 * @param userName search user based on user name 
	 * @param password search user based on password
	 * @return the changed password
	 */
	@Override
	public int changePassword(String userName,String password) {
		return userDao.changePassword(userName,password);
	}

}
