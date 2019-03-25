package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.service.PostServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/posts")
    public List<PostDTO> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/post/user/{username}")
    public List<PostDTO> getPostByUsername(@PathVariable String username) {
        return postService.getPostByUsername(username);
    }

    @GetMapping("/post/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/post")
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }

    @PutMapping("/post/{id}/approve/{boo}")
    public PostDTO ApprovePost(@PathVariable Long id, @PathVariable boolean boo) {
        return postService.ApprovePost(id, boo);
    }

    @PutMapping("/post/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }


}
