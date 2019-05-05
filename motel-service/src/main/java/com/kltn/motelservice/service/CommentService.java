package com.kltn.motelservice.service;

import com.kltn.motelservice.model.CommentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {

    Page<CommentDTO> getCommentByIdPost(Long idPost, int page);

    CommentDTO createComment(CommentDTO commentDTO, String email);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    String deleteComment(Long id);
}
