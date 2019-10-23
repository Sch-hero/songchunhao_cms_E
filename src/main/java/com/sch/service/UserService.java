package com.sch.service;
import com.sch.entity.User;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
public interface UserService {
	
	int register(User user) ;
	User login(User user);
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	boolean checkUserExist(String username);
	

}
