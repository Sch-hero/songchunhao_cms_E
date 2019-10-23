package com.sch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sch.entity.Cat;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
@Mapper
public interface CatMapper {

	/**
	 * 
	 * @param chnlId 频道主键id
	 * @return
	 */
	@Select("SELECT id,name,channel_id channelId "
			+ " FROM cms_category "
			+ " WHERE channel_id=#{value}")
	List<Cat> selectByChnlId(Integer chnlId);

	/**
	 * 根据Id获取对应得分类
	 * @param id
	 * @return
	 */
	Cat findById(Integer id);
}

