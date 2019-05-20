package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.RoleName;
import com.kltn.motelservice.entity.User;
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
    public Page<PostDTO> searchPost(SearchDTO searchForm, @RequestParam int page, @RequestParam int sort){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
        return postService.searchPost(searchForm, page, sort);
    }

    @GetMapping("/posts/searchbymaps")
    public Page<PostDTO> searchPostMaps(SearchDTO searchForm, @RequestParam int page){
        searchForm.setPriceStart(searchForm.getPriceStart()*1000000);
        searchForm.setPriceEnd(searchForm.getPriceEnd()*1000000);
//        searchForm.setRadius(searchForm.getRadius()/1000);
        return postService.searchPostByMaps(searchForm, page);
    }

    @GetMapping("/posts")
    public Page<PostDTO> getAllPost(@PageableDefault(page = 0, size = 12) Pageable  page) {
        return postService.getAllPost(page);
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
    public Page<PostDTO> getMotelPost(@PathVariable boolean bool, @RequestParam int page, @RequestParam int sort) {
        return postService.getMotelPost(bool, page, sort);
    }

    @GetMapping("/posts/waiting")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public Page<PostDTO> getPostWaitingApprove(@RequestParam int page) {
        return postService.getPostWaitingApprove(page);
    }

    @GetMapping("/post/user/{idUser}")
    public Page<PostDTO> getPostByIdUser(@PathVariable long idUser, @RequestParam int page, OAuth2Authentication auth) {
        return postService.getPostByIdUser(idUser, page, auth);
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
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public PostDTO ApprovePostAndLogging(@PathVariable Long id, @PathVariable boolean bool, OAuth2Authentication auth) {
        return postService.ApprovePost(id, auth.getName(), bool);
    }

    @PutMapping("/post/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO, OAuth2Authentication auth) {
        return postService.updatePost(id, postDTO, auth.getName());
    }

    @PutMapping("/post/hide/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public PostDTO hidePost(@PathVariable Long id) {
        return postService.hidePost(id);
    }

    @DeleteMapping("/post/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public String deletePostByAdmin(@PathVariable Long id) {
        return postService.deletePostByAdmin(id);
    }

}
