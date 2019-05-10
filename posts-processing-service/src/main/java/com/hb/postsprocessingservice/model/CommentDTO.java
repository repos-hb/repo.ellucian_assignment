package com.hb.postsprocessingservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommentDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	private int postId;
	private String email;
	private String body;
	
	public CommentDTO(int postId, String body) {
		this.postId = postId;
//		this.email = email;
		this.body=body;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//if(ValidateEmail(email))
			this.email = email;
	}

//	private boolean ValidateEmail(String email) {
//		
//		if(email!=null) {
//			List<Character> list = new ArrayList<Character>();
//			char[] chars = email.toCharArray();
//			for(char c: chars) {
//				list.add(c);
//			}
//			
//			int i1=0;
//			int i2=0;
//			int i3=0;
//			if(list.contains('@')) {
//				i1=list.indexOf('@');
//			} else if(list.contains('.')) {
//				i2=list.indexOf('.');
//			} 
	
//			
//			
//			
//		}
//		return false;
//	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
