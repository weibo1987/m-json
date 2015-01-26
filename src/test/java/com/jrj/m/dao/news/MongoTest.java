/**  
 * @Title: NewsDaoTest.java
 * @Package com.jrj.m.dao
 * @Description: TODO
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月20日 下午1:31:56
 * @version V1.0  
 */ 
package com.jrj.m.dao.news;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.BSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jrj.m.dao.mongo.HistoryDao;
import com.jrj.m.dao.mongo.NewsDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


/**
 * 
 * @author weibo.qin
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dataSource.xml")
public class MongoTest {


	@Autowired
	private HistoryDao historyDao;
	@Autowired
	private NewsDao newsDao;
	
	public void addNewsTest() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("title","news title。。。。。。。。");
		map.put("author","作者");
		map.put("content","内容");
		map.put("tags",new String[]{"mongoDB","NOSQL"});
		map.put("cTime", new Date());
		
		DBObject bo=new BasicDBObject(map);
		
		int lineNum=this.newsDao.insert(bo);
		System.out.println(lineNum);
		
	}


	public void findAllNewsTest(){
	}
	@Test
	public void findByQuery(){
		
		System.out.println(this.newsDao.getReadPreference().getName());
		System.out.println(this.historyDao.getReadPreference().getName());
		
		List<BSONObject> list=historyDao.findAll();
		for(BSONObject bo:list){
			System.out.println(bo.toString());
		}
		
	}

	public void removeByQueryTest(){
	}

	//	    @Test
	public void updateTest(){
		
//		Map<String>
		
		
//		this.historyDao.getDBCollection().update(new BasicDBObject("title", "news title。。。。。。。。"), );
	}


}
