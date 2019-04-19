package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Comment;
import com.kltn.motelservice.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
