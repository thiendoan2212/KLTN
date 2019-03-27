package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Comment;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.exception.CommentException;
import com.kltn.motelservice.exception.PostException;
import com.kltn.motelservice.model.CommentDTO;
import com.kltn.motelservice.repository.CommentRepository;
import com.kltn.motelservice.repository.PostRepository;
import com.kltn.motelservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        try {
            Optional<Post> post = postRepository.findById(commentDTO.getIdPost());
            if (post.isPresent()) {
                Comment comment = new Comment();
                comment.setContent(commentDTO.getContent());
                comment.setLastUpdate(LocalDateTime.now());
                Optional<User> user = userRepository.findByUsername(commentDTO.getUsername());
                comment.setPost(post.get());
                comment.setUser(user.get());
                commentRepository.save(comment);
                commentDTO = modelMapper.map(comment, CommentDTO.class);
                commentDTO.setUsername(comment.getUser().getUsername());
                return commentDTO;
            } else
                throw new PostException("Không tồn tại post id " + commentDTO.getIdPost());
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi thêm bình luận ", e);
        }
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (!comment.isPresent())
                throw new CommentException("Comment id " + id + "không tồn tại!!!");
            else {
                commentDTO.setId(id);
                comment.get().setContent(commentDTO.getContent());
                comment.get().setLastUpdate(LocalDateTime.now());
                commentRepository.save(comment.get());
                commentDTO = modelMapper.map(comment.get(), CommentDTO.class);
                return commentDTO;
            }
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi sửa bình luận ", e);
        }
    }

    @Override
    public String deleteComment(Long id) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (!comment.isPresent())
                throw new CommentException("Comment id " + id + "không tồn tại!!!");
            else {
                commentRepository.delete(comment.get());
                return "Đã xóa comment id " + id;
            }
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi xóa bình luận ", e);
        }
    }
}
