package com.songchunhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.utils.Md5Utils;
import com.songchunhao.dao.UserMapper;
import com.songchunhao.entity.User;
import com.songchunhao.service.UserService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	

	/**
	 * 注册
	 */
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User existUser = userMapper.findByName(user.getUsername());
		if(existUser!=null) {
			return -1;// 用户已经存在
		}
		//设置密码密文
		user.setPassword(
				Md5Utils.md5(user.getPassword(),user.getUsername()));
		
		return userMapper.add(user);
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		// 获取密码密文
		String pwdStr = Md5Utils.md5(user.getPassword(),user.getUsername());
		//根据用户名称查找用户
		User loginUser =  userMapper.findByName(user.getUsername());
		//判断数据库中密码密文与与计算所得的密文是否相同
		if(loginUser!=null && pwdStr.equals(loginUser.getPassword())) {
			//登录成功
			return loginUser;
		}
		//登录失败
		return null;
	}

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	@Override
	public boolean checkUserExist(String username) {
		// TODO Auto-generated method stub
		return null!=userMapper.findByName(username);
		
	}
	
	
	//獲取所以用戶
			@Override
			public PageInfo<User> list(Integer page,int locked) {
				// TODO Auto-generated method stub
				System.out.println(" ============ page is " + page);
				PageHelper.startPage(page, 10);
				return new PageInfo<User>(userMapper.list(locked));
			}
			
			//解封用戶
			@Override
			public int update(Integer id ,String locked) {
				// TODO Auto-generated method stub
				return userMapper.update(id ,locked);
			}
			
			
			@Override
			public int addHead_picture(User user) {
				// TODO Auto-generated method stub
				return userMapper.addHead_picture(user);
			}

}
