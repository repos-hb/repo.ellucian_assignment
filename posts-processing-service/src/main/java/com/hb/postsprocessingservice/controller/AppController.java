package com.hb.postsprocessingservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hb.postsprocessingservice.model.PostDTO;
import com.hb.postsprocessingservice.service.PostsFetchService;

@RestController
@RequestMapping(path = "/posts")
public class AppController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private PostsFetchService postsFetchService;
	
	@GetMapping
	public boolean getAllPosts() {
		LOGGER.info("AppController.getAllPosts");
		 return postsFetchService.fetchAndSend();
	}
	
	@GetMapping(path = "/db")
	public List<PostDTO> getPostsFromDb() {
		LOGGER.info("AppController.getPostsFromDb");
		 return postsFetchService.fetch();
	}

}
