/**  
* @Title: NewsController.java
* @Package com.jrj.m.controllers
* @Description: TODO
* @author ping.lv ping.lv@jrj.com.cn  
* @date 2015年1月19日 下午4:17:36
* @version V1.0  
*/ 
package com.jrj.m.controllers.news;

import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrj.m.controllers.NotBlank;
import com.jrj.m.model.news.News;
import com.jrj.m.service.news.NewsService;

/**
 * @ClassName: NewsController
 * @Description: 资讯栏目
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月19日 下午4:17:36
 *
 */
@Path("") 
public class NewsController {
	
	@Autowired     
	private NewsService newsService; 
	 
	
	@Get("index")
	public String index(Invocation inv) throws Exception
	{
		List<News> newsList = newsService.find(); 
		inv.addModel("newsList", newsList);         
		return "index"; 
	}
	@Get("add")
	public String add(Invocation inv) throws Exception
	{      
		return "add"; 
	}
	@Post("insert")
	public String insert(News news) throws Exception
	{
		newsService.add(news);     
		return "redirect:/news/index"; 
	}
	@Get("update")
	public String update(Invocation inv,@NotBlank@Param("iiid") int iiid) throws Exception
	{   
		News news = newsService.getNewsById(iiid);
		inv.addModel("news", news);  
		return "update"; 
	}
	@Post("modify")
	public String modify(News news) throws Exception
	{
		newsService.update(news);     
		return "redirect:/news/index"; 
	}
	@Get("del")
	public String del(Invocation inv,@Param("iiid") int iiid) throws Exception
	{   
		newsService.del(iiid);
		return "redirect:/news/index"; 
	}
	@Get("json")
    public String getJson() throws Exception {
        List<News> newsList = newsService.find();
        JSONArray json=JSONArray.fromObject(newsList);
        return "@var json="+json.toString();
    }
}
