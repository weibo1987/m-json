package com.jrj.m.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.BSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
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
	/**
	 * 获取当前数据源的mark
	 * @return
	 */
	public abstract String getMongoDataSourceMark();
	/**
	 * 动态获得mongoClient
	 * @return
	 */
	public MongoClient getMongoClient(){
		////	在工厂内设置目标数据源的标志
		mongoFactory.getRout().setDefaultTargetDataSourceMark(getMongoDataSourceMark());
		return mongoFactory.createMongoClient();
	}
	
	/**
	 * 动态获得默认的DBCollection
	 * @return
	 */
	public DBCollection getDBCollection() {
		////	在工厂内设置目标数据源的标志
		mongoFactory.getRout().setDefaultTargetDataSourceMark(getMongoDataSourceMark());
		////	获取验证时的默认DB对象
		DB db=mongoFactory.createMongoClient().getDB(mongoFactory.getRout().getDataSourceByEnum(getMongoDataSourceMark()).getDbName());
		return db.getCollection(getDynamicCollectionName(this.getClass().getName()));
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
		return findByCondition(condition,new BasicDBObject());
	}
	
	public List<BSONObject> findByCondition(DBObject condition,DBObject fieldsSelected){
		List<BSONObject> result=new ArrayList<BSONObject>();
		DBCursor cursor=this.getDBCollection().find(condition,fieldsSelected);
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
