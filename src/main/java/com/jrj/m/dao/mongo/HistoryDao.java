package com.jrj.m.dao.mongo;

import org.springframework.stereotype.Component;

import com.mongodb.ReadPreference;

/**
 * 
 * @author weibo.qin
 *
 */
@Component
public class HistoryDao extends AbstarctMongoDao{

	@Override
	public ReadPreference getReadPreference() {
		return ReadPreference.secondary();
	}

	@Override
	public String getMongoDataSourceMark() {
		return null;
	}
	
	
}
