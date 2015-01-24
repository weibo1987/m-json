package com.jrj.m.dao.mongo;

import org.springframework.stereotype.Component;

import com.jrj.m.model.news.News;
import com.mongodb.ReadPreference;

/**
 * 
 * @author weibo.qin
 *
 */
@Component
public class NewsDao extends AbstarctMongoDao{

	@Override
	public ReadPreference getReadPreference() {
		return ReadPreference.SECONDARY;
	}

	
}
