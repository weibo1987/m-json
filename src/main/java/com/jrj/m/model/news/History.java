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
import java.util.Arrays;
import java.util.Date;

/**
 * MONGO
 * 为了测试固定集合。淘汰老数据，测试bean
 * 
 * @author weibo.qin
 *
 */
public class History implements Serializable {

	private static final long serialVersionUID = -8075778072913908440L;
	
	private String title;
	private String author;
	private String content;
	private String[] tags;
	private Integer comments;
	private Date cTime;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Integer getComments() {
		return comments;
	}
	public void setComments(Integer comments) {
		this.comments = comments;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public History() {
		super();
	}
	
	public History(String title, String author, String content, String[] tags,
			Integer comments, Date cTime) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.tags = tags;
		this.comments = comments;
		this.cTime = cTime;
	}
	@Override
	public String toString() {
		return "History [title=" + title + ", author=" + author + ", content="
				+ content + ", tags=" + Arrays.toString(tags) + ", comments="
				+ comments + ", cTime=" + cTime + "]";
	}
	
}
