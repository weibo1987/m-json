package com.jrj.m.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.BSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;

/**
 * 
 * 定义抽象mongoDao
 * 
 * @author weibo.qin
 *
 */
public abstract class AbstarctMongoDao{
	
	@Autowired
	private JRJMongoFactory mongoFactory;
	
	Log log=LogFactory.getLog(this.getClass());
	
	private final static String DOT=".";
	private final static String DAO_SUFFIX="Dao";
	
	/**
	 * 定义钩子方法  动态获取ReadPreference 模式
	 * @return
	 */
	public abstract ReadPreference getReadPreference();
	
	public DBCollection getDBCollection() {
		mongoFactory.getClient().setReadPreference(getReadPreference());
		return mongoFactory.getDB().getCollection(getDynamicCollectionName(this.getClass().getName()));
	}

	private String getDynamicCollectionName(String name) {
		try{
			name= name.substring(name.lastIndexOf(DOT)+DOT.length(),name.lastIndexOf(DAO_SUFFIX)).toLowerCase();
		}catch(Exception e){
			log.error("Dao类名不正确，请检查！", e);
		}
		return name;
	}
	
	/**
	 * 查询所有的对象
	 * @return
	 */
	public List<BSONObject> findAll(){
		List<BSONObject> result=new ArrayList<BSONObject>();
		DBCursor cursor=this.getDBCollection().find().batchSize(2);
		while(cursor.hasNext()){
			System.out.println(cursor);
			result.add(cursor.next());
		}
		return result;
	};
	
	/**
	 * 根据条件查询相应的对象
	 * @param condition
	 * @return
	 */
	public List<BSONObject> findByCondition(DBObject condition){
		List<BSONObject> result=new ArrayList<BSONObject>();
		DBCursor cursor=this.getDBCollection().find(condition).batchSize(2);
		while(cursor.hasNext()){
			result.add(cursor.next());
		}
		return result;
	}
	
	public int insert(DBObject... arr){
		WriteResult wr=this.getDBCollection().insert(arr);
		System.out.println(wr.toString());
		return wr.getN();
	}
	
}
