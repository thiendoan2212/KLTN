package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Image;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.exception.ImageException;
import com.kltn.motelservice.repository.ImageRepository;
import com.kltn.motelservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public Image storeImage(Long idPost, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new ImageException("Tệp có đường dẫn không hợp lệ" + fileName);
            }
            Optional<Post> post = postRepository.findById(idPost);
            Image image = new Image(fileName, file.getContentType(), file.getBytes(), post.get());

            return imageRepository.save(image);
        } catch (IOException ex) {
            throw new ImageException("Xảy ra lỗi trong quá trình lưu ảnh " + fileName + ".!", ex);
        }
    }

    @Override
    public Image getImage(String imageId) {
        return imageRepository.findById(imageId)
                .orElseThrow(() -> new ImageException("Không tim thấy ảnh có id " + imageId));
    }

    @Override
    public List<String> getImageByIdPost(Long idPost) {
        List<String> Uri = new ArrayList<>();
        Optional<Post> post = postRepository.findById(idPost);
        List<Image> images = imageRepository.findImageByPost(post.get());
        for (Image image : images)
             Uri.add(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(image.getId())
                    .toUriString());
        return Uri;
    }
}
