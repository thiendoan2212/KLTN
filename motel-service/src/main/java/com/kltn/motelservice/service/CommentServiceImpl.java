package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Comment;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.exception.CommentException;
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

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        try {
            if (commentDTO == null)
                throw new NullPointerException("Đối tượng rỗng");
            else {
                Comment comment = new Comment();
                comment.setContent(commentDTO.getContent());
                comment.setLastUpdate(LocalDateTime.now());
                Optional<Post> post = postRepository.findById(commentDTO.getIdPost());
                Optional<User> user = userRepository.findByUsername(commentDTO.getUsername());
                comment.setPost(post.get());
                comment.setUser(user.get());
                commentRepository.save(comment);
                return commentDTO;
            }
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi thêm bình luận ", e);
        }
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        try {
            if (commentDTO == null)
                throw new NullPointerException("Đối tượng rỗng");
            else {
                Optional<Comment> comment = commentRepository.findById(id);
                if (!comment.isPresent())
                    throw new CommentException("Comment id " + id + "không tồn tại!!!");
                else {
                    commentDTO.setId(id);
                    comment.get().setContent(commentDTO.getContent());
                    commentRepository.save(comment.get());
                }
            }
            return commentDTO;
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi sửa bình luận ", e);
        }
    }

    @Override
    public void deleteComment(Long id) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (!comment.isPresent())
                throw new CommentException("Comment id " + id + "không tồn tại!!!");
            else {
                commentRepository.delete(comment.get());
            }
        } catch (Exception e) {
            throw new CommentException("Xảy ra lỗi khi xóa bình luận ", e);
        }
    }
}
