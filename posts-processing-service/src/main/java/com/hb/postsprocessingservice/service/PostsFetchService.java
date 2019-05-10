package com.hb.postsprocessingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hb.postsprocessingservice.model.Post;
import com.hb.postsprocessingservice.model.PostDTO;
import com.hb.postsprocessingservice.repository.PostsRepository;

@Service
public class PostsFetchService {
	
	private static final String POSTS_QUEUE = "posts.queue";
	private static final Logger LOGGER = LoggerFactory.getLogger(PostsFetchService.class);
	
	@Value("${api.url}")
	private String API_URL;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PostsRepository postsRepository;
	
	public boolean fetchAndSend() {
		LOGGER.info("PostsFetchService.fetchAndSend");
		
		List<Post> listOfPosts = new ArrayList<>();
		
		ResponseEntity<List<Post>> response = 
				restTemplate.exchange(API_URL, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Post>>() {
						});
		
		listOfPosts = response.getBody();
		LOGGER.info("Fetch size: "+listOfPosts.size());
		if(sendPostsToJmsQueue(listOfPosts))
			return true;
		return false;
		
	}

	// producer service
	public boolean sendPostsToJmsQueue(List<Post> listOfPosts) {
		LOGGER.info("PostsFetchService.sendPostsToJmsQueue");
		
		final int MAX = 25;
		int count= 0;
//		Collections.shuffle(listOfPosts);
		
		if (listOfPosts.size() > MAX) {
			for (int i=0;i<MAX;i++) {
				jmsTemplate.convertAndSend(POSTS_QUEUE, listOfPosts.get(i));
				count++;
			}
		} else {
			for (Post p: listOfPosts) {
				jmsTemplate.convertAndSend(POSTS_QUEUE, p);
				count++;
			}
		}
		
		if(count==MAX)
			return true;
		return false;
	}

	public List<PostDTO> fetch() {
		LOGGER.info("PostsFetchService.fetch");
		
		List<PostDTO> list = new ArrayList<>();
		postsRepository.findAll()
				.forEach(list::add);
		return list;
	}	
	

}
