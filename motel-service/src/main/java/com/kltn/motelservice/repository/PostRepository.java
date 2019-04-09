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

    List<Post> findAllByApprovedAndNotApproved(boolean approved, boolean notApproved);

    List<Post> findAllByApprovedAndNotApprovedAndAndAccomodation_Motel(boolean approved, boolean notApproved, boolean motel);
}
