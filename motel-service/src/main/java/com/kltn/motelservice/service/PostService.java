package com.kltn.motelservice.service;

import com.kltn.motelservice.model.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPost();

    List<PostDTO> getPostByUsername(String username);

    PostDTO getPostById(Long id);

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    String deletePost(Long id);

    PostDTO ApprovePost(Long id, boolean isApprove);
}
