package com.songchunhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songchunhao.dao.CatMapper;
import com.songchunhao.entity.Cat;
import com.songchunhao.service.CatService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@Service
public class CatServiceImpl implements CatService{
	
	@Autowired
	CatMapper catMapper;

	/**
	 * 根据频道去获取下边的分类
	 * @param id
	 * @return
	 */
	@Override
	public List<Cat> getListByChnlId(Integer id) {
		// TODO Auto-generated method stub
		return catMapper.selectByChnlId(id);
	}
	

}
