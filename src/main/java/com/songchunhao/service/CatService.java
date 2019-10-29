package com.songchunhao.service;

import java.util.List;

import com.songchunhao.entity.Cat;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface CatService {
	
	/**
	 * 根据频道去获取下边的分类
	 * @param id
	 * @return
	 */
	List<Cat> getListByChnlId(Integer id);  
	

}
