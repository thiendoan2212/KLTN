package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.*;
import com.kltn.motelservice.exception.PostException;
import com.kltn.motelservice.exception.UserException;
import com.kltn.motelservice.model.AccomodationDTO;
import com.kltn.motelservice.model.CommentDTO;
import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.model.SearchDTO;
import com.kltn.motelservice.repository.DistrictRepository;
import com.kltn.motelservice.repository.PostRepository;
import com.kltn.motelservice.repository.PostSpecification;
import com.kltn.motelservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

    @Autowired
    ImageServiceImpl imageService;

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
    public List<PostDTO> getPostByApproved(boolean bool) {
        List<Post> posts;
        List<PostDTO> postDTOS = new ArrayList<>();
        if (bool == true) {
            posts = postRepository.findAllByApprovedAndNotApproved(true, false);
        } else {
            posts = postRepository.findAllByApprovedAndNotApproved(false, true);
        }
        addAccomodation(posts, postDTOS);
        return postDTOS;
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
            Optional<Post> post = postRepository.findPostById(id);
            if (post.isPresent()) {
                PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);
                postDTO.setAccomodationDTO(modelMapper.map(post.get().getAccomodation(), AccomodationDTO.class));
                postDTO.setUsername(post.get().getUser().getUsername());
                List<CommentDTO> commentDTOS = new ArrayList<>();
                CommentDTO commentDTO;
                for (Comment comment : post.get().getComments()) {
                    commentDTO = modelMapper.map(comment, CommentDTO.class);
                    commentDTO.setUsername(comment.getUser().getUsername());
                    commentDTOS.add(commentDTO);
                }
                List<String> images;
                images = imageService.getImageByIdPost(id);
                postDTO.setImageStrings(images);
                postDTO.setCommentDTOS(commentDTOS);

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
                //Gán value cho post
                Post post = new Post();
                post = modelMapper.map(postDTO, Post.class);
                post.setCreateAt(LocalDateTime.now());
                post.setLastUpdate(LocalDateTime.now());
                post.setUser(user.get());
//                post.setDelete(false);
//                post.setApproved(false);
//                post.setNotApproved(false);
                //Gán value cho accomodation
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
                postDTO.getAccomodationDTO().setId(post.get().getAccomodation().getId());
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
    public PostDTO deletePost(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                post.get().setDel(true);
                postRepository.save(post.get());
                PostDTO postDTO = modelMapper.map(post.get(), PostDTO.class);

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
    public List<PostDTO> getMotelPost(boolean bool) {
        try {
            List<Post> posts;
            List<PostDTO> postDTOS = new ArrayList<>();
            //Get Motel
            if (bool == true) {
                posts = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_Motel(true, false, true);
            } else { //Get House
                posts = postRepository.findAllByApprovedAndNotApprovedAndAndAccomodation_Motel(true, false, false);
            }
            addAccomodation(posts, postDTOS);
            return postDTOS;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deletePostByAdmin(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                postRepository.delete(post.get());
                return "Admin đã xóa post id " + id;
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

    @Override
    public List<PostDTO> searchPost(SearchDTO searchForm) {
        try {
            Specification<Post> spec = new PostSpecification(searchForm);
            List<Post> posts = postRepository.findAll(spec);
            List<PostDTO> postDTOS = new ArrayList<>();
            addAccomodation(posts, postDTOS);
            return postDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PostDTO> searchPostByMaps(SearchDTO searchForm) {
        try {
            Specification<Post> spec = new PostSpecification(searchForm);
            List<Post> posts = postRepository.findAll(spec);
            List<PostDTO> postDTOS = new ArrayList<>();
            PostDTO postDTO;
            List<String> images;
            for (Post post : posts) {
                if (distance(post.getAccomodation().getxCoordinate(), post.getAccomodation().getyCoordinate(), searchForm.getxCoordinate(), searchForm.getyCoordinate())
                        < searchForm.getRadius()) {
                    postDTO = modelMapper.map(post, PostDTO.class);
                    postDTO.setAccomodationDTO(modelMapper.map(post.getAccomodation(), AccomodationDTO.class));
                    postDTO.setUsername(post.getUser().getUsername());
                    images = imageService.getImageByIdPost(post.getId());
                    postDTO.setImageStrings(images);
                    postDTOS.add(postDTO);
                }
            }
            return postDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAccomodation(List<Post> posts, List<PostDTO> postDTOS) {
        for (Post post : posts) {
            PostDTO postDTO = modelMapper.map(post, PostDTO.class);
            postDTO.setAccomodationDTO(modelMapper.map(post.getAccomodation(), AccomodationDTO.class));
            postDTO.setUsername(post.getUser().getUsername());
            List<String> images = imageService.getImageByIdPost(post.getId());
            postDTO.setImageStrings(images);
            postDTOS.add(postDTO);
        }
    }

    //Haversine formula
    public double distance(double lat1, double lng1, double lat2, double lng2) {
        int r = 6371; // average radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r * c;
        d = Math.pow(d, 2);
        return d;
    }
}
