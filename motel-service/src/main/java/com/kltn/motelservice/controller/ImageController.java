package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Image;
import com.kltn.motelservice.model.ImageDTO;
import com.kltn.motelservice.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping("/uploadImage/post/{idPost}")
    public ImageDTO uploadFile(@PathVariable Long idPost, @RequestParam("file") MultipartFile file) {
        return imageService.uploadFile(idPost, file);
    }

    @DeleteMapping("/deleteImage/post/{idPost}")
    public void deleteFile(@PathVariable Long idPost) {
        imageService.deleteAllImage(idPost);
    }

    @PostMapping("/uploadMultipleFiles/post/{idPost}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public List<ImageDTO> uploadMultipleFiles(@PathVariable Long idPost, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(idPost, file))
                .collect(Collectors.toList());
    }

    @GetMapping("/imageByte/post/{idPost}")
    public List<ImageDTO> getImageDTOByIdPost(@PathVariable Long idPost) {
        return imageService.getImageDTOByIdPost(idPost);
    }

    @GetMapping("/image/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Image image = imageService.getImage(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
//                .header("attachment; filename=\"" + image.getFileName() + "\"")
                .body(new ByteArrayResource(image.getData()));
    }

    @GetMapping("/image/post/{idPost}")
    public List<String> getImageByIdPost(@PathVariable Long idPost) {
        return imageService.getImageByIdPost(idPost);
    }
}
