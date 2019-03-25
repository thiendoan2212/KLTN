package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Image;
import com.kltn.motelservice.model.ImageDTO;
import com.kltn.motelservice.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        Image image = imageService.storeImage(idPost, file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(image.getId())
                .toUriString();

        return new ImageDTO(image.getId(), image.getFileName(), file.getContentType(), fileDownloadUri, idPost);
    }

    @PostMapping("/uploadMultipleFiles/post/{idPost}")
    public List<ImageDTO> uploadMultipleFiles(@PathVariable Long idPost, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(idPost, file))
                .collect(Collectors.toList());
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
