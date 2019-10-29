package com.songchunhao.service;

import com.github.pagehelper.PageInfo;
import com.songchunhao.entity.User;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface UserService {
	//注册用户
	int register(User user) ;
	//登录
	User login(User user);
	/**
	 * 	//判断用户名是否已经被占用
	 * @param username
	 * @return
	 */
	boolean checkUserExist(String username);
	
	//用户管理//用户管理 禁用和解封
	PageInfo<User> list(Integer page, int locked);
	
	//修改禁止该用户
	int update(Integer id ,String locked);
	
	//个人主要上传头像
	int addHead_picture(User user);

}
