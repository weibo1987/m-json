package com.jrj.m.dao.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * 
 * @author weibo.qin
 *
 */
public class JRJMongoFactory{

	Log log=LogFactory.getLog(this.getClass());
	/**
	 * 保存所有数据源的mongoClient池组
	 */
	private final static ConcurrentHashMap<String, MongoClient> mongoClientPool=new ConcurrentHashMap<String, MongoClient>();
	/**
	 * mongo 数据源路由
	 */
	private MongoDataSourceRoute rout;
	
	public MongoDataSourceRoute getRout() {
		return rout;
	}

	public void setRout(MongoDataSourceRoute rout) {
		this.rout = rout;
	}
	
	private JRJMongoFactory() {
	}
	
	/**
	 * 构建mongoClient
	 * @return
	 */
	public MongoClient createMongoClient() {

		if(mongoClientPool.contains(rout.getDefaultTargetDataSourceMark())) return mongoClientPool.get(rout.getDefaultTargetDataSourceMark());
		
		if(StringUtils.isEmpty(this.rout.getDecideDataSource().getHostports())){
			log.error("副本集端口信息不能为空！");
			return null;
		}

		String[] hostPortArray=this.rout.getDecideDataSource().getHostports().split(",");

		List<ServerAddress> serverAddressList=new ArrayList<ServerAddress>();
		List<MongoCredential> mongoCredentialList=new ArrayList<MongoCredential>();

		try {
			for(String hostport:hostPortArray){
				serverAddressList.add(new ServerAddress(hostport.split(":")[0],Integer.parseInt(hostport.split(":")[1])));
				mongoCredentialList.add(MongoCredential.createCredential(this.rout.getDecideDataSource().getDbUser(), this.rout.getDecideDataSource().getDbName(), this.rout.getDecideDataSource().getDbPwd().toCharArray()));
			}
		} catch (UnknownHostException e) {
			log.error("未知host", e);
			return null;
		}
		
		mongoClientPool.put(rout.getDefaultTargetDataSourceMark(), new MongoClient(serverAddressList,mongoCredentialList));
		
		return mongoClientPool.get(rout.getDefaultTargetDataSourceMark());
	}
	
	
}
