package com.example.restservice;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.restservice.DAL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

	@GetMapping("/posts")
	public ArrayList<Post> posts() {
		ArrayList<Post> posts = dal.GetPosts();
		return posts;
	}

	@PostMapping("posts")
	public String postMethodName(@RequestBody String entity) {
		//TODO convert input to object parameters
		Post newPost = new Post(entity, entity, null);
		dal.AddPostToStorage(newPost);
		return entity;
	}
	
}