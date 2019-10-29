package com.songchunhao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songchunhao.dao.ChannelMapper;
import com.songchunhao.entity.Article;
import com.songchunhao.entity.Channel;
import com.songchunhao.service.ChannelService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
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
	
	@Override
	public List<Article> getSreach(String title) {
		// TODO Auto-generated method stub
		return channelMapper.sreach(title);
	}

}
