package com.sch.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.dao.ChannelMapper;
import com.sch.entity.Channel;
import com.sch.service.ChannelService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
@Service
public class ChannelServiceImpl implements ChannelService{
	
	@Autowired
	ChannelMapper channelMapper;
	
	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	@Override
	public List<Channel> getAllChnls() {
		// TODO Auto-generated method stub
		return channelMapper.listAll();
	
	}

}
