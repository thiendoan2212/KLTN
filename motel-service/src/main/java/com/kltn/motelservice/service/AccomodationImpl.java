package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Accomodation;
import com.kltn.motelservice.entity.District;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.exception.AccomodationException;
import com.kltn.motelservice.model.AccomodationDTO;
import com.kltn.motelservice.repository.AccomodationRepository;
import com.kltn.motelservice.repository.DistrictRepository;
import com.kltn.motelservice.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccomodationImpl implements AccomodationService {
    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PostRepository postRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public AccomodationDTO createAccomodation(AccomodationDTO accomodationDTO) {
        try {
            Optional<Post> post = postRepository.findById(accomodationDTO.getIdPost());
            Optional<District> district = districtRepository.findById(accomodationDTO.getIdDistrict());
            if (post.isPresent()) {
                Accomodation accomodation = modelMapper.map(accomodationDTO, Accomodation.class);
                accomodation.setPost(post.get());
                accomodation.setDistrict(district.get());
            } else {
                throw new AccomodationException("Có lỗi xảy ra vui lòng thử lại!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccomodationDTO updateAccomodation(Long id, AccomodationDTO accomodationDTO) {
        try {
            Optional<Accomodation> accomodation = accomodationRepository.findById(id);
            if (accomodation.isPresent()) {
                Optional<District> district = districtRepository.findById(accomodationDTO.getIdDistrict());
                accomodation = Optional.of(modelMapper.map(accomodationDTO, Accomodation.class));
                accomodation.get().setDistrict(district.get());
                accomodationRepository.save(accomodation.get());

                return accomodationDTO;
            } else {
                throw new AccomodationException("Không tìm thấy accomodation id " + accomodationDTO.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteAccomodation(Long id) {
        try {
            Optional<Accomodation> accomodation = accomodationRepository.findById(id);
            if (accomodation.isPresent()) {
                accomodationRepository.delete(accomodation.get());
            } else {
                throw new AccomodationException("Không tìm thấy accomodation id " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
