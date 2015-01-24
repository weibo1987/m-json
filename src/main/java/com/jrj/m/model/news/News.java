/**  
 * @Title: News.java
 * @Package com.jrj.m.domain
 * @Description: 资讯bean
 * @author ping.lv ping.lv@jrj.com.cn  
 * @date 2015年1月19日 下午4:22:37
 * @version V1.0  
 */
package com.jrj.m.model.news;

import java.io.Serializable;

/**
 * @ClassName: News
 * @Description: 资讯bean
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月19日 下午4:22:37
 *
 */
public class News implements Serializable {

	private static final long serialVersionUID = -8075778072913908440L;
	// 资讯ID
	private long iiid;
	// 资讯标题
	private String title;
	// 资讯简介
	private String intro;

	/**
	 * @return iiid
	 */
	public long getIiid() {
		return iiid;
	}

	/**
	 * @param iiid
	 *            要设置的 iiid
	 */
	public void setIiid(long iiid) {
		this.iiid = iiid;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return intro
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro
	 *            要设置的 intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "News [iiid=" + iiid + ", title=" + title + ", intro=" + intro
				+ "]";
	}
	
	
}
