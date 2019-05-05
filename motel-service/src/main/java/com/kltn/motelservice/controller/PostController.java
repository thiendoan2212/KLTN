package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.model.SearchDTO;
import com.kltn.motelservice.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/posts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public List<PostDTO> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/approved/true")
    public Page<PostDTO> getAllPostApproved(@RequestParam int page) {
        return postService.getPostByApproved(true, page);
    }

    @GetMapping("/posts/approved/false")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public Page<PostDTO> getAllPostNotApproved(@RequestParam int page) {
        return postService.getPostByApproved(false, page);
    }

    @GetMapping("/posts/motel/{bool}")
    public Page<PostDTO> getMotelPost(@PathVariable boolean bool, @RequestParam int page) {
        return postService.getMotelPost(bool, page);
    }

    @GetMapping("/posts/waiting")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
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
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public PostDTO createPost(@RequestBody PostDTO postDTO, OAuth2Authentication auth) {
        return postService.createPost(postDTO, auth.getName());
    }

    @PutMapping("/post/{id}/approve/{bool}")
//    @PreAuthorize("#oauth2.hasAnyScope('read')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public PostDTO ApprovePostAndLogging(@PathVariable Long id, @PathVariable boolean bool, OAuth2Authentication auth) {
        return postService.ApprovePost(id, auth.getName(), bool);
    }

    @PutMapping("/post/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @PutMapping("/post/delete/{id}")
    public PostDTO deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @DeleteMapping("/post/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public String deletePostByAdmin(@PathVariable Long id) {
        return postService.deletePostByAdmin(id);
    }
}
