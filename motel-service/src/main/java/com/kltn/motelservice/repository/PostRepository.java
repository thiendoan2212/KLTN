package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    List<Post> findByUser(User user);

    Page<Post> findAll(Specification specification, Pageable pageable);

    Optional<Post> findPostById(Long id);

    List<Post> findAllByApprovedAndNotApproved(boolean approved, boolean notApproved);

    Page<Post> findAllByApprovedAndNotApproved(boolean approved, boolean notApproved, Pageable pageable);

    List<Post> findAllByApprovedAndNotApprovedAndAndAccomodation_Motel(boolean approved, boolean notApproved, boolean motel);

    Page<Post> findAllByApprovedAndNotApprovedAndAndAccomodation_Motel(boolean approved, boolean notApproved, boolean motel, Pageable pageable);
}
