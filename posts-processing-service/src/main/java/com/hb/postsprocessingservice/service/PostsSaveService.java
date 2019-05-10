package com.hb.postsprocessingservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.hb.postsprocessingservice.model.Post;
import com.hb.postsprocessingservice.model.PostDTO;
import com.hb.postsprocessingservice.model.PostDtoPK;
import com.hb.postsprocessingservice.repository.PostsRepository;

@Service
public class PostsSaveService {

	private static final String POSTS_QUEUE = "posts.queue";
	private static final Logger LOGGER = LoggerFactory.getLogger(PostsSaveService.class);
	
	@Autowired
	private PostsRepository postsRepository;
	
	@JmsListener(destination = POSTS_QUEUE)
	public void receiveAndSave(Post post) {
		
		LOGGER.info("PostsSaveService.receiveAndSave");
		LOGGER.info("Message "+post.getId()+": "+post);
		
		PostDtoPK postDtoPk = new PostDtoPK(post.getUserId(),post.getTitle());
		PostDTO postDto = new PostDTO();
		postDto.setPostDtoPk(postDtoPk);
		
		postsRepository.save(postDto);
	}
}
