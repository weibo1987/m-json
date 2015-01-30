package com.jrj.m.dao.mongo;

import java.util.HashMap;
import java.util.Map;

public class MongoDataSourceRoute {
	
	/**
	 *	所有数据源的集合
	 */
	Map<String,MongoDataSource> dataSourceMap=new HashMap<String,MongoDataSource>();
	/**
	 * 目标数据源标志
	 */
	private String defaultTargetDataSourceMark;
	
	
	public void setDataSourceMap(Map<String, MongoDataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}
	public String getDefaultTargetDataSourceMark() {
		return defaultTargetDataSourceMark;
	}
	public void setDefaultTargetDataSourceMark(String defaultTargetDataSourceMark) {
		this.defaultTargetDataSourceMark = defaultTargetDataSourceMark;
	}
	
	/**
	 * 获得决定后的数据源
	 * @return
	 */
	public MongoDataSource getDecideDataSource(){
		return dataSourceMap.get(dataSourceMap);
	}
	
	/**
	 * 根据mark标志 获得所需的数据源
	 * @param mark
	 * @return
	 */
	public MongoDataSource getDataSourceByEnum(String mark){
		return this.dataSourceMap.get(mark);
	}


}
