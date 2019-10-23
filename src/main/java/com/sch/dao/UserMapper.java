package com.sch.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sch.entity.User;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
public interface UserMapper {

	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO cms_user(username,password,gender,create_time) "
			+ "values(#{username},#{password},#{gender},now())")
	int add(User user);
	
	/**
	 * 根据用户名查找
	 * @param username
	 * @return
	 */
	@Select("SELECT id,username,password,role,locked FROM cms_user "
			+ "WHERE username=#{value} limit 1")
	User findByName(String username);
	

}
