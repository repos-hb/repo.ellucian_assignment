package com.hb.postsprocessingservice.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts_master_table")
public class PostDTO implements Serializable{

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	private int userId;
//	private String title;
	
	@EmbeddedId
	private PostDtoPK postDtoPk;

	public PostDTO() {

	}

	public PostDtoPK getPostDtoPk() {
		return postDtoPk;
	}

	public void setPostDtoPk(PostDtoPK postDtoPk) {
		this.postDtoPk = postDtoPk;
	}
	
	

//	public PostDTO(int userId, String title) {
//		this.userId = userId;
//		this.title = title;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}

}
