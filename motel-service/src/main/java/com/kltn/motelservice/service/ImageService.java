package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image storeImage(Long idPost, MultipartFile file);

    Image getImage(String imageId);

    List<String> getImageByIdPost(Long idPost);
}
