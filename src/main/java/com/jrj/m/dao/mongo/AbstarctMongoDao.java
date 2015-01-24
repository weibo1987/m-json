package com.jrj.m.dao.mongo;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.ReadPreference;

/**
 * 
 * 定义抽象mongoDao
 * 
 * @author weibo.qin
 *
 */
public abstract class AbstarctMongoDao {
	
	@Autowired
	private JRJMongoClient mongoClient;

	/**
	 * 定义钩子方法  动态获取ReadPreference 模式
	 * @return
	 */
	public abstract ReadPreference getReadPreference();
	
	public JRJMongoClient getMongoClient() {
		this.mongoClient.setReadPreference(this.getReadPreference());
		return this.mongoClient.getClient();
	}
	
}
