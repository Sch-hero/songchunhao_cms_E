package com.sch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.dao.CatMapper;
import com.sch.entity.Cat;
import com.sch.service.CatService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
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
