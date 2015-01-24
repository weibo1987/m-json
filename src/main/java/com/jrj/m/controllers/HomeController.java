/**  
 * @Title: HomeController.java
 * @Package com.jrj.m.controllers
 * @Description: M站点首页入口
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月19日 下午4:11:09
 * @version V1.0  
 */
package com.jrj.m.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrj.m.service.news.NewsService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * @ClassName: HomeController
 * @Description: M站点首页入口
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月19日 下午4:11:09
 *
 */

@Path("")
public class HomeController {
	@Autowired     
	private NewsService newsService; 
	/**
	 * 默认跳转到新闻首页
	* @Title: redirect
	* @Description: TODO
	* @param @param inv
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@Get
	public String redirect(Invocation inv) {
		return "r:/news/index";
	}
}
