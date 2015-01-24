/**  
 * @Title: NewsService.java
 * @Package com.jrj.m.service
 * @Description: 资讯service
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月19日 下午5:43:06
 * @version V1.0  
 */
package com.jrj.m.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrj.m.dao.news.NewsDAO;
import com.jrj.m.model.news.News;

/**
 * @ClassName: NewsService
 * @Description: 资讯service
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月19日 下午5:43:06
 *
 */
@Service
public class NewsService {
	@Autowired
	private NewsDAO newsDAO;

	/**
	 * 
	 * @Title: find
	 * @Description: 查
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	public List<News> find() {
		return newsDAO.find();
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 增
	 * @param @param news
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	public int add(News news) {
		return newsDAO.add(news);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 改
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	public int update(News news) {
		return newsDAO.update(news);
	}

	/**
	 * 
	 * @Title: del
	 * @Description: 删
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	public int del(int iiid) {
		return newsDAO.del(iiid);
	}

	/**
	 * 
	 * @Title: getTestsById
	 * @Description: 查
	 * @param @param id
	 * @param @return 设定文件
	 * @return News 返回类型
	 * @throws
	 */
	public News getNewsById(int iiid) {
		return newsDAO.getNewsById(iiid);
	}
}
