package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.model.SearchDTO;
import com.kltn.motelservice.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/posts/search")
    public Page<PostDTO> searchPost(SearchDTO searchForm, @RequestParam int page){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
        return postService.searchPost(searchForm, page);
    }

    @GetMapping("/posts/searchbymaps")
    public List<PostDTO> searchPostMaps(SearchDTO searchForm){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
//        searchForm.setRadius(searchForm.getRadius()/1000);
        return postService.searchPostByMaps(searchForm);
    }

    // HasAuthorize = "KDV, Admin"
    @GetMapping("/posts")
    public Page<PostDTO> getAllPost(@PageableDefault(page = 0, size = 12) Pageable  page) {
        return postService.getAllPost(page);
    }

    @GetMapping("/posts/approved/true")
    public Page<PostDTO> getAllPostApproved(@RequestParam int page) {
        return postService.getPostByApproved(true, page);
    }

    // Pre = "Admin"
    @GetMapping("/posts/approved/false")
    public Page<PostDTO> getAllPostNotApproved(@RequestParam int page) {
        return postService.getPostByApproved(false, page);
    }

    @GetMapping("/posts/motel/{bool}")
    public Page<PostDTO> getMotelPost(@PathVariable boolean bool, @RequestParam int page) {
        return postService.getMotelPost(bool, page);
    }

    // HasAuthorize = "KDV, Admin"
    @GetMapping("/posts/waiting")
    public Page<PostDTO> getPostWaitingApprove(@RequestParam int page) {
        return postService.getPostWaitingApprove(page);
    }

    @GetMapping("/post/user/{idUser}")
    public List<PostDTO> getPostByIdUser(@PathVariable long idUser) {
        return postService.getPostByIdUser(idUser);
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
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public PostDTO ApprovePostAndLogging(@PathVariable Long id, @PathVariable boolean bool, OAuth2Authentication auth) {
        return postService.ApprovePost(id, auth.getName(), bool);
    }

    @PutMapping("/post/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @PutMapping("/post/delete/{id}")
    public PostDTO deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    // HasAuthorize = "KDV, Admin"
    @DeleteMapping("/post/{id}")
    public String deletePostByAdmin(@PathVariable Long id) {
        return postService.deletePostByAdmin(id);
    }
}
