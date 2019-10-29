package com.songchunhao.service;


import java.util.List;

import com.songchunhao.entity.Article;
import com.songchunhao.entity.Channel;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface ChannelService {

	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	List<Channel> getAllChnls();
	

	List<Article> getSreach(String title);

}
