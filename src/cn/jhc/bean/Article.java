package cn.jhc.bean;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;

public class Article {
	private int id;
	private String title;
	private String content;
	private int creator;
	private Date publishDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("id", id)
				.add("title", title)
				.add("content", content)
				.add("creator", creator)
				.add("publishDate", publishDate.toString())
				.build();
	}
}
