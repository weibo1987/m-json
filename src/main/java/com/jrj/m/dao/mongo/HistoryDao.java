package com.jrj.m.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.springframework.stereotype.Component;

import com.mongodb.DBCursor;
import com.mongodb.ReadPreference;

/**
 * 
 * @author weibo.qin
 *
 */
@Component
public class HistoryDao extends AbstarctMongoDao implements Op{

	@Override
	public ReadPreference getReadPreference() {
		return ReadPreference.PRIMARY;
	}
	
	
}
