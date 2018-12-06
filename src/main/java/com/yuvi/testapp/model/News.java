package com.yuvi.testapp.model;

public class News {
	private String title;
	private String description;
	private int id;
	
	
	public News(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public News() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
}
