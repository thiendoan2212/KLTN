package com.kltn.motelservice.service;

import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.model.SearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<PostDTO> getAllPost(Pageable page);

//    List<PostDTO> getPostByApproved(boolean bool);

    Page<PostDTO> getPostByApproved(boolean bool, int page);

    Page<PostDTO> getPostByIdUser(long idUser, int page);

    PostDTO getPostById(Long id);

    PostDTO createPost(PostDTO postDTO, String name);

    PostDTO updatePost(Long id, PostDTO postDTO);

    PostDTO deletePost(Long id);

    Page<PostDTO> getMotelPost(boolean bool, int page);

    String deletePostByAdmin(Long id);

//    PostDTO ApprovePost(Long idPost, Long idUserApprove, boolean isApprove);

    PostDTO ApprovePost(Long idPost, String usernameApprover, boolean isApprove);

//    List<PostDTO> searchPost(SearchDTO searchForm);

    Page<PostDTO> searchPost(SearchDTO searchForm, int page);

    List<PostDTO> searchPostByMaps(SearchDTO searchForm);

    Page<PostDTO> getPostWaitingApprove( int page);
}
