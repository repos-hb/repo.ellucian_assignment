package com.hb.postsprocessingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hb.postsprocessingservice.model.PostDTO;
import com.hb.postsprocessingservice.model.PostDtoPK;

public interface PostsRepository extends CrudRepository<PostDTO, PostDtoPK> {
	
	public List<PostDTO> findAllByUserId(int id);

}
