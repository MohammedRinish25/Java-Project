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
	 * @param user
	 * @return
	 */
	@Override
	public String register(User user) {
		return userDao.addUser(user);
	}

	/**
	 * @param userName
	 * @param password
	 * @return
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

	@Override
	public int changePassword(String userName,String password) {
		return userDao.changePassword(userName,password);
	}

}
