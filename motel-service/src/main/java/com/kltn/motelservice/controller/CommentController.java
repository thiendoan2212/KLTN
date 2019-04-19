package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Comment;
import com.kltn.motelservice.model.CommentDTO;
import com.kltn.motelservice.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/comments/post/{id}")
    public List<CommentDTO> getCommentByIdPost(@PathVariable Long id) {
        return commentService.getCommentByIdPost(id);
    }
    @GetMapping("/comments/posts/{id}")
    public Page<CommentDTO> getComment(@PathVariable Long id, @RequestParam("page") int page) {
        return commentService.getCommentByIdPost(id, page);
    }

    @PostMapping("/comment/post")
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @PutMapping("/comment/{id}")
    public CommentDTO updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        return commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}