package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.model.SearchDTO;
import com.kltn.motelservice.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostServiceImpl postService;

//    @GetMapping("/posts/search")
//    public Page<PostDTO> searchPost(SearchDTO searchForm, @RequestParam int page){
//        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
//        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
//        return postService.searchPost(searchForm, page);
//    }

    @GetMapping("/posts/search")
    public List<PostDTO> searchPost(SearchDTO searchForm){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
        return postService.searchPost(searchForm);
    }

    @GetMapping("/posts/searchbymaps")
    public List<PostDTO> searchPostMaps(SearchDTO searchForm){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
//        searchForm.setRadius(searchForm.getRadius()/1000);
        return postService.searchPostByMaps(searchForm);
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/approved/{approved}")
    public List<PostDTO> getAllPostApproved(@PathVariable boolean approved) {
        return postService.getPostByApproved(approved);
    }

//    @GetMapping("/posts/approved/{approved}")
//    public Page<PostDTO> getAllPostApproved(@PathVariable boolean approved, @RequestParam int page) {
//        return postService.getPostByApproved(approved, page);
//    }

    @GetMapping("/posts/motel/{bool}")
    public List<PostDTO> getMotelPost(@PathVariable boolean bool) {
        return postService.getMotelPost(bool);
    }

//    @GetMapping("/posts/motel/{bool}")
//    public Page<PostDTO> getMotelPost(@PathVariable boolean bool, @RequestParam int page) {
//        return postService.getMotelPost(bool, page);
//    }

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

    @PutMapping("/post/{id}/approve/{bool}")
    public PostDTO ApprovePost(@PathVariable Long id, @PathVariable boolean bool) {
        return postService.ApprovePost(id, bool);
    }

    @PutMapping("/post/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @PutMapping("/post/delete/{id}")
    public PostDTO deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @DeleteMapping("/post/{id}")
    public String deletePostByAdmin(@PathVariable Long id) {
        return postService.deletePostByAdmin(id);
    }
}
