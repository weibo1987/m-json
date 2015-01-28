/**  
 * @Title: NewsService.java
 * @Package com.jrj.m.service
 * @Description: 资讯service
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月19日 下午5:43:06
 * @version V1.0  
 */
package com.jrj.m.service.test;

import java.util.List;

import org.bson.BSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrj.m.dao.mongo.HistoryDao;
import com.jrj.m.dao.mongo.NewsDao;
import com.mongodb.BasicDBObject;

/**
 * 
 * @author weibo.qin
 *
 */
@Service
public class TestMongoService {
	@Autowired
	private HistoryDao historyDao;
	@Autowired
	private NewsDao newsDao;
	
	/**
	 * 
	 * @Title: find
	 * @Description: 查
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	public List<BSONObject> find() {
		return historyDao.findAll();
	}
	
	public List<BSONObject> findNews() {
		return newsDao.findAll();
	}

	public List<BSONObject> findNewsList() {
		return newsDao.findByCondition(new BasicDBObject(), new BasicDBObject("title", 1).append("pub_time", 1));
	}

}
