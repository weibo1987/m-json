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

	@Override
	public List<BSONObject> findAll() {
		List<BSONObject> result=new ArrayList<BSONObject>();
		DBCursor cursor=this.getMongoClient().getDB("foo").getCollection("history").find().batchSize(2);
		while(cursor.hasNext()){
			result.add(cursor.next());
		}
		return result;
	}
	
	
}
