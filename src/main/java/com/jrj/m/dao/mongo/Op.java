package com.jrj.m.dao.mongo;

import java.util.List;

import org.bson.BSONObject;

public interface Op {
	
	/**
	 * 查询所有的对象
	 * @return
	 */
	public List<BSONObject> findAll();
	
}
