package com.kltn.motelservice.service;

import com.kltn.motelservice.model.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    String deleteComment(Long id);
}
