package com.songchunhao.service;

import java.util.List;

import com.songchunhao.entity.Comment;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface CommnentService {


	List<Comment> commnentlist(Integer articleId);

	/**
	 * 发布评论
	 * @param id
	 * @param articleId
	 * @param content
	 */
	void comment(Integer id, Integer articleId, String content);

}
