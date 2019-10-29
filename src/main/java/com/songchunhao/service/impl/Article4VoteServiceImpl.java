package com.songchunhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songchunhao.dao.Article4VoteMapper;
import com.songchunhao.entity.Article4Vote;
import com.songchunhao.entity.VoteStatic;
import com.songchunhao.service.Article4VoteService;

/**
 * 
 * @宋春浩
 *
 * 2019年10月29日
 */
@Service
public class Article4VoteServiceImpl implements Article4VoteService {
	
	@Autowired
	Article4VoteMapper avMapper;

	
	/**
	 * 
	 * 添加投票
	 */
	@Override
	public int publish(Article4Vote av) {
		// TODO Auto-generated method stub
		return avMapper.add(av);
	}

	/**
	 * 显示投票题目
	 */
	@Override
	public List<Article4Vote> list() {
		// TODO Auto-generated method stub
		return avMapper.list();
	}

	/**
	 * 根据idx显示投票选项
	 */
	@Override
	public Article4Vote findById(Integer id) {
		// TODO Auto-generated method stub
		return avMapper.getById(id);
	}

	@Override
	public int vote(Integer articleId, Character option) {
		// TODO Auto-generated method stub
		//return avMapper.vote(userId,  articleId,  option);
		return avMapper.vote(articleId,  option);
	}

	
	@Override
	public List<VoteStatic> getVoteStatics(Integer articleId) {
		// TODO Auto-generated method stub
		return avMapper.getVoteStatics(articleId);
	}

}
