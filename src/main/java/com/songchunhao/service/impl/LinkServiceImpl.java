package com.songchunhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songchunhao.comon.CMSRuntimeException;
import com.sch.utils.StringUtils;
import com.songchunhao.dao.LinkMapper;
import com.songchunhao.entity.Link;
import com.songchunhao.service.LinkService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public List<Link> linklist() {
		// TODO Auto-generated method stub
		return linkMapper.linklist();
	}
	
	//友情链接的删除
	@Override
	public int deletelink(Integer id) {
		// TODO Auto-generated method stub
		return linkMapper.deletelink(id);
	}

	@Override
	public int addLink(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.addlink(link);
	}
}
