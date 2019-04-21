package com.kltn.motelservice.service;

import com.kltn.motelservice.model.CommentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
//    List<CommentDTO> getCommentByIdPost(Long idPost);

    Page<CommentDTO> getCommentByIdPost(Long idPost, int page);

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    String deleteComment(Long id);
}
