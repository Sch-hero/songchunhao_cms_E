package com.sch.dao;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.sch.entity.Channel;

/**
 * 
 * @宋春浩
 *
 * 2019年10月18日
 */
public interface ChannelMapper {

	/**
	 * 获取所有的频道
	 * @return
	 */
	@Select("SELECT * FROM cms_channel ORDER BY id")
	List<Channel> listAll();

	/**
	 * 根据id获取对应得频道
	 * @param id
	 * @return
	 */
	Channel findById(Integer id);
}
