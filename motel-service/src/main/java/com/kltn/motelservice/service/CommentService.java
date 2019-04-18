package com.kltn.motelservice.service;

import com.kltn.motelservice.model.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getCommentByIdPost(Long idPost);

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    String deleteComment(Long id);
}
