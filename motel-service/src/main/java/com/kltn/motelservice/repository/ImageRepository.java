package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Image;
import com.kltn.motelservice.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findImageByPost(Post post);
}
