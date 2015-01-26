/**  
* @Title: NewsDaoTest.java
* @Package com.jrj.m.dao
* @Description: TODO
* @author ping.lv ping.lv@jrj.com.cn  
* @date 2015年1月20日 下午1:31:56
* @version V1.0  
*/ 
package com.jrj.m.dao.news;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jrj.m.dao.news.NewsDAO;
import com.jrj.m.model.news.News;



/**
 * @ClassName: NewsDaoTest
 * @Description: TODO
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月20日 下午1:31:56
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dataSource.xml")
public class NewsDAOTest {
	
	  @Autowired
	  private NewsDAO newsDAO;
	  @Qualifier("jade.dataSource.com.jrj.m.dao")
	  @Autowired
	  private BasicDataSource dataSource;
	  @Before
	  public void init() {
//	        try {
//	             Connection conn = dataSource.getConnection();
//	             Statement st = conn.createStatement();
//	             //st.execute("drop all objects;");
//	             //st.execute("runscript from '" + new DefaultResourceLoader().getResource("schema.sql").getURL().toString() + "'");
//	             st.close();
//	            conn.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	    }

	    @Test
	    public void getNewsTest() {
//	        List<News> newsList = newsDAO.find();
//	        System.out.print(newsList.toString());
	        //for(News news:newsList)
	        	
	       // for(News news:newsList)
	       //Assert.assertEquals(2, news.getIiid());
	    }
}
