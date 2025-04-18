package com.example.restservice;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

		//For simplicity's sake, the setup of the API and its dependency injections is done in this class
	private final DAL dal;

	public Controller(DAL dal){
		this.dal = dal;
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ("Hello");
	}

	@CrossOrigin
	@GetMapping("/posts")
	public ArrayList<Post> posts() {
		return dal.GetPosts();
	}

	@CrossOrigin
	@PostMapping("posts")
	public String postNew(@RequestBody String entity) {
		//TODO convert input to object parameters
		System.out.println(entity);
		ObjectMapper objectMapper = new ObjectMapper();
        Post newPost = null;
        try {
            newPost = objectMapper.readValue(entity, Post.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        dal.AddPostToStorage(newPost);
		return entity;
	}
	
}