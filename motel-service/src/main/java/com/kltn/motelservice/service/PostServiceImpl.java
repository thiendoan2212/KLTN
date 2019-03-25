package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Accomodation;
import com.kltn.motelservice.entity.District;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.exception.PostException;
import com.kltn.motelservice.exception.UserException;
import com.kltn.motelservice.model.AccomodationDTO;
import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.repository.DistrictRepository;
import com.kltn.motelservice.repository.PostRepository;
import com.kltn.motelservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DistrictRepository districtRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PostDTO> getAllPost() {
        try {
            List<PostDTO> postDTOS = new ArrayList<>();
            List<Post> posts = postRepository.findAll();
            addAccomodation(posts, postDTOS);

            return postDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PostDTO> getPostByUsername(String username) {
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                List<PostDTO> postDTOS = new ArrayList<>();
                List<Post> posts = postRepository.findByUser(user.get());
                addAccomodation(posts, postDTOS);

                return postDTOS;
            } else
                throw new UserException("Không tìm thấy user " + username);
//                logger.error("Không tìm thấy user " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostDTO getPostById(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);
                postDTO.setAccomodationDTO(modelMapper.map(post.get().getAccomodation(), AccomodationDTO.class));
                return postDTO;
            } else
                throw new PostException("Post id " + id + " không tồn tại");
//                logger.error("Post id " + id + " không tồn tại");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        try {
            Optional<User> user = userRepository.findByUsername(postDTO.getUsername());
            if (user.isPresent()) {
                Post post = new Post();
                post.setTitle(postDTO.getTitle());
                post.setContent(postDTO.getContent());
                post.setCreateAt(LocalDateTime.now());
                post.setLastUpdate(LocalDateTime.now());
                post.setUser(user.get());
                post.setDelete(false);
                post.setApproved(false);
                post.setNotApproved(false);
                Accomodation accomodation = modelMapper.map(postDTO.getAccomodationDTO(), Accomodation.class);
                accomodation.setPost(post);
                Optional<District> district = districtRepository.findById(postDTO.getAccomodationDTO().getIdDistrict());
                accomodation.setDistrict(district.get());
                post.setAccomodation(accomodation);

                postRepository.save(post);
                postDTO = modelMapper.map(post, PostDTO.class);
                postDTO.setAccomodationDTO(modelMapper.map(accomodation, AccomodationDTO.class));
                postDTO.setUsername(post.getUser().getUsername());
                return postDTO;
            } else
                throw new UserException("Không tìm thấy user " + postDTO.getUsername());
//                logger.error("Không tìm thấy user " + postDTO.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                postDTO.setId(id);
                postDTO.setCreateAt(post.get().getCreateAt());
                //Tạo post mới từ postDTO
                post = Optional.of(modelMapper.map(postDTO, Post.class));
                Optional<User> user = userRepository.findByUsername(postDTO.getUsername());
                post.get().setUser(user.get());
                //Tạo accomodation từ postDTO
                Accomodation accomodation = modelMapper.map(postDTO.getAccomodationDTO(), Accomodation.class);
                accomodation.setPost(post.get());
                accomodation.setId(postDTO.getAccomodationDTO().getId());
                Optional<District> district = districtRepository.findById(postDTO.getAccomodationDTO().getIdDistrict());
                accomodation.setDistrict(district.get());
                post.get().setLastUpdate(LocalDateTime.now());
                post.get().setAccomodation(accomodation);
                postRepository.save(post.get());
                postDTO = modelMapper.map(post.get(), PostDTO.class);
                postDTO.setAccomodationDTO(modelMapper.map(post.get().getAccomodation(), AccomodationDTO.class));
                postDTO.setUsername(post.get().getUser().getUsername());

                return postDTO;
            } else
                throw new PostException("Không tìm thấy post id " + id);
//                logger.error("Không tìm thấy post id " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deletePost(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                post.get().setDelete(true);
                return "Đã xóa post id " + id;
            } else
                throw new PostException("Không tìm thấy post id " + id);
//                logger.error("Không tìm thấy post id " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostDTO ApprovePost(Long id, boolean isApprove) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (!post.isPresent())
                throw new PostException("Không tìm thấy post id " + id);
            if (isApprove) {
                post.get().setApproved(true);
                post.get().setNotApproved(false);
            } else {
                post.get().setNotApproved(true);
                post.get().setApproved(false);
            }
            postRepository.save(post.get());
            PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);

            return postDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAccomodation(List<Post> posts, List<PostDTO> postDTOS) {
        for (Post post : posts) {
            PostDTO postDTO = modelMapper.map(post, PostDTO.class);
            postDTO.setAccomodationDTO(modelMapper.map(post.getAccomodation(), AccomodationDTO.class));
            postDTOS.add(postDTO);
        }
    }
}
