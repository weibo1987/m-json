/**  
 * @Title: NewsDaoTest.java
 * @Package com.jrj.m.dao
 * @Description: TODO
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月20日 下午1:31:56
 * @version V1.0  
 */ 
package com.jrj.m.dao.news;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jrj.m.dao.mongo.HistoryDao;


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

	public void addNewsTest() {
	}


	public void findAllNewsTest(){
	}
	@Test
	public void findByQuery(){
		System.out.println(historyDao.findAll().toString());
	}

	public void removeByQueryTest(){
	}

	//	    @Test
	public void updateTest(){
	}


}
