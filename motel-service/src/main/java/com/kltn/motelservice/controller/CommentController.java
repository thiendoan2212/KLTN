package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.CommentDTO;
import com.kltn.motelservice.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @PostMapping("/comment/post")
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @PutMapping("/comment/{id}")
    public CommentDTO updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        return commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable Long id){
        return commentService.deleteComment(id);
    }
}