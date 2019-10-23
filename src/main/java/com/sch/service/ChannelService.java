package com.sch.service;
import java.util.List;
import com.sch.entity.Channel;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
public interface ChannelService {

	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	List<Channel> getAllChnls();

}
