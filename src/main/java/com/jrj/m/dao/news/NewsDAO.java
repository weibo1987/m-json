/**  
 * @Title: NewsDao.java
 * @Package com.jrj.m.dao
 * @Description: 资讯DB
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月20日 上午10:47:48
 * @version V1.0  
 */
package com.jrj.m.dao.news;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.jrj.m.model.news.News;

/**
 * @ClassName: NewsDao
 * @Description: 资讯DB
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月20日 上午10:47:48
 *
 */
@DAO
public interface NewsDAO {
	/**
	 * 
	 * @Title: find
	 * @Description: 查
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	@SQL("select iiid, title,intro from info_item order by iiid desc ")
	public List<News> find();

	/**
	 * 
	 * @Title: add
	 * @Description: 增
	 * @param @param news
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	@ReturnGeneratedKeys
	@SQL("insert into info_item(title,intro) values(:t.title,:t.intro);")
	public int add(@SQLParam("t") News news);

	/**
	 * 
	 * @Title: update
	 * @Description: 改
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	@SQL("update info_item set title=:t.title,intro=:t.intro where iiid=:t.iiid")
	public int update(@SQLParam("t") News news);

	/**
	 * 
	 * @Title: del
	 * @Description: 删
	 * @param @return 设定文件
	 * @return List<News> 返回类型
	 * @throws
	 */
	@SQL("DELETE  from info_item where iiid =:iiid")
	public int del(@SQLParam("iiid") int iiid);

	/**
	 * 
	 * @Title: getNewsById
	 * @Description: 查
	 * @param @param id
	 * @param @return 设定文件
	 * @return News 返回类型
	 * @throws
	 */
	@SQL("SELECT iiid, title,intro from info_item where iiid =:iiid")
	public News getNewsById(@SQLParam("iiid") int iiid);
}
