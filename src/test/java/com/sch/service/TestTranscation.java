package com.sch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.songchunhao.entity.Article;
import com.songchunhao.service.ArticleService;

/**\
 * 测试事务
 * @宋春浩
 *
 * 2019年10月28日
 */
public class TestTranscation extends BaseTest {
	
	@Autowired
	ArticleService articleService;

	/**
	 * 
	 */
	@Test
	public void testAddArticle() {
		Article article = new Article();
		article.setContent("测试内容22");
		article.setTags(" zhSANG1222,LISI22");
		articleService.add(article);
		
		
	}
}
