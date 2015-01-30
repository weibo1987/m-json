package com.jrj.m.dao.mongo;

public class MongoDataSource {

	private String dbName;
	private String dbUser;
	private String dbPwd;
	private String hostports;
	private String readPrefrence;
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPwd() {
		return dbPwd;
	}
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
	public String getReadPrefrence() {
		return readPrefrence;
	}
	public void setReadPrefrence(String readPrefrence) {
		this.readPrefrence = readPrefrence;
	}
	public String getHostports() {
		return hostports;
	}
	public void setHostports(String hostports) {
		this.hostports = hostports;
	}
	
}
