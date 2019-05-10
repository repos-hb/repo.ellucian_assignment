package com.hb.postsprocessingservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PostDtoPK implements Serializable{

	private static final long serialVersionUID = 4733942689808478919L;
	
	private int userId;
	private String title;
	
	public PostDtoPK() {
		
	}

	public PostDtoPK(int userId, String title) {
		this.userId = userId;
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
