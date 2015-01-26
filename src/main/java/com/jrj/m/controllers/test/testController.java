/**  
* @Title: NewsController.java
* @Package com.jrj.m.controllers
* @Description: TODO
* @author ping.lv ping.lv@jrj.com.cn  
* @date 2015年1月19日 下午4:17:36
* @version V1.0  
*/ 
package com.jrj.m.controllers.test;

import java.util.List;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.sf.json.JSONArray;

import org.bson.BSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.jrj.m.model.news.News;
import com.jrj.m.service.test.TestMongoService;

/**
 * 
 * @author weibo.qin
 *
 */
@Path("") 
public class testController {
	
	@Autowired     
	private TestMongoService mongoService;
	
	@Get("json")
    public String getJson() throws Exception {
        List<BSONObject> newsList = mongoService.find();
        JSONArray json=JSONArray.fromObject(newsList);
        return "@"+json.toString();
    }
}
