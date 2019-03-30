package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Accomodation;
import com.kltn.motelservice.entity.District;
import com.kltn.motelservice.model.AccomodationDTO;
import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.repository.AccomodationRepository;
import com.kltn.motelservice.repository.DistrictRepository;
import com.kltn.motelservice.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceImpl implements AccomodationService {
    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PostRepository postRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<AccomodationDTO> searchAccomodation(boolean bool) {
//        Optional<District> district = districtRepository.findById(idDistrict);
////        List<Accomodation> accomodations = accomodationRepository.findAccomodationsByAcreageBetweenAndMotelAndDistrict(acreageStart, acreageEnd,
////                isMotel, district.get());
////        List<Accomodation> accomodations = accomodationRepository.findAccomodationByAcreageBetween(acreageStart, acreageEnd);
//        List<AccomodationDTO> accomodationDTOS = new ArrayList<>();
////        for (Accomodation accomodation : accomodations) {
////            AccomodationDTO accomodationDTO = modelMapper.map(accomodation, AccomodationDTO.class);
////            PostDTO postDTO = modelMapper.map(accomodation.getPost(), PostDTO.class);
////            postDTO.setUsername(accomodation.getPost().getUser().getUsername());
////            accomodationDTO.setPostDTO(postDTO);
////            accomodationDTOS.add(accomodationDTO);
////        }
//        List<Accomodation> accomodations = accomodationRepository.findAllByMotel(true);
//        List<AccomodationDTO> accomodationDTOS = new ArrayList<>();
//        for (Accomodation accomodation : accomodations) {
//            accomodationDTOS.add(modelMapper.map(accomodation, AccomodationDTO.class));
//        }
        return null;
    }
}
