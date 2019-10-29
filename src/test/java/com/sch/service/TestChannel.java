package com.sch.service;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.songchunhao.entity.Cat;
import com.songchunhao.entity.Channel;
import com.songchunhao.service.CatService;
import com.songchunhao.service.ChannelService;

public class TestChannel  extends BaseTest{
	
	@Autowired
	ChannelService cs; 
	
	@Autowired
	CatService catService;
	
	
	@Test
	public void testChannel() {
		List<Channel> allChnls = 
		cs.getAllChnls();
		allChnls.forEach(x->{
			System.out.println(" x is " + x);
		});
		
		
	}
	
	@Test
	public void testCat() {
		List<Cat> list = catService.getListByChnlId(3);
		list.forEach(cat->{System.out.println("cat is " + cat);});
		
	}
}
