package com.songchunhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.songchunhao.entity.Article;
import com.songchunhao.entity.Channel;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public interface ChannelMapper {

	/**
	 * 获取所有的频道
	 * @return
	 */
	@Select("SELECT * FROM cms_channel ORDER BY id")
	List<Channel> listAll();
	
	/**
	 *  根据id获取对应的频道
	 * @param id
	 * @return
	 */
	/*@Select("SELECT * FROM cms_channel WHERE id = #{value} limit 1")*/
	Channel findById(Integer id);

	// 首页模糊查询
	@Select("select * from cms_article where title like concat('%',#{title},'%') ")
	List<Article> sreach(@Param("title")String title);
	
	

}
