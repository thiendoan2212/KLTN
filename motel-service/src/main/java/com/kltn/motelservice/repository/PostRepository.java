package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

    Optional<Post> findPostById(Long id);
}
