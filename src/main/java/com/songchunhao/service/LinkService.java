package com.songchunhao.service;

import java.util.List;

import com.songchunhao.entity.Link;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface LinkService {
	//获取友情链接
	List<Link> linklist();
	//获取友情链接添加
	int addLink(Link link);
	
	//获取友情链接的删除
	int deletelink(Integer id);
}
