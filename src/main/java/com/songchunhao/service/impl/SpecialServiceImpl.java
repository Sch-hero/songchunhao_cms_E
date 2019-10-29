package com.songchunhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songchunhao.dao.ArticleMapper;
import com.songchunhao.dao.SpecialMapper;
import com.songchunhao.entity.Special;
import com.songchunhao.service.SpecialService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
@Service
public class SpecialServiceImpl  implements SpecialService{
	
	@Autowired
	SpecialMapper specialMapper; 
	
	@Autowired
	ArticleMapper  articleMapper; 

	@Override
	public List<Special> list() {
		// TODO Auto-generated method stub
		
		List<Special> list =  specialMapper.list();
		for (Special special : list) {
			special.setArticleNum(articleMapper.getArticleNum(special.getId()));
		}
		return list;
	}

	@Override
	public int add(Special special) {
		// TODO Auto-generated method stub
		return specialMapper.add(special);
	}

	@Override
	public Special findById(Integer id) {
		// TODO Auto-generated method stub
		Special special = specialMapper.findById(id);
		special.setArtilceList(articleMapper.findBySepecailId(id));
		return special;
	}

	@Override
	public int addArticle(Integer specId, Integer articleId) {
		// TODO Auto-generated method stub
		return specialMapper.addArticle( specId,  articleId);
	}

	@Override
	public int removeArticle(Integer specId, Integer articleId) {
		// TODO Auto-generated method stub
		return specialMapper.removeArticle(specId, articleId);
	}

	@Override
	public int update(Special special) {
		// TODO Auto-generated method stub
		return specialMapper.update(special);
	}

}
