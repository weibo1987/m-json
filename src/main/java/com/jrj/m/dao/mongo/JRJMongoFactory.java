package com.jrj.m.dao.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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

	private String dbUser;
	private String dbPassword;
	private String dbName;
	private String hostports;
	private  MongoClient client;

	private JRJMongoFactory(String dbUser, String dbPassword, String dbName,
			String hostports) throws UnknownHostException {
		super();
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		this.dbName = dbName;
		this.hostports = hostports;
		initMongoClient();
	}

	private JRJMongoFactory() {
	}

	private void initMongoClient(){

		if(StringUtils.isEmpty(hostports)){
			log.error("副本集端口信息不能为空！");
			return ;
		}

		String[] hostPortArray=hostports.split(",");

		List<ServerAddress> serverAddressList=new ArrayList<ServerAddress>();
		List<MongoCredential> mongoCredentialList=new ArrayList<MongoCredential>();

		try {
			for(String hostport:hostPortArray){
				serverAddressList.add(new ServerAddress(hostport.split(":")[0],Integer.parseInt(hostport.split(":")[1])));
				mongoCredentialList.add(MongoCredential.createCredential(dbUser, dbName, dbPassword.toCharArray()));
			}
		} catch (UnknownHostException e) {
			log.error("未知host", e);
			return ;
		}
		
		if(client==null){
			synchronized (this) {
				client=new MongoClient(serverAddressList,mongoCredentialList);
			}
		}
	}


	/**
	 * get DB connection.
	 * @return
	 */
	public DB getDB(){
		return client.getDB(dbName);
	}


	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getHostports() {
		return hostports;
	}
	public void setHostports(String hostports) {
		this.hostports = hostports;
	}

	public MongoClient getClient() {
		return client;
	}

}
