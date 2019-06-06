package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Criteria;
import com.kltn.motelservice.entity.District;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.exception.CriteriaException;
import com.kltn.motelservice.exception.UserException;
import com.kltn.motelservice.model.CriteriaDTO;
import com.kltn.motelservice.model.DistrictDTO;
import com.kltn.motelservice.repository.CriteriaRepository;
import com.kltn.motelservice.repository.DistrictRepository;
import com.kltn.motelservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CriteriaServiceImpl implements CriteriaService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CriteriaRepository criteriaRepository;

    @Autowired
    DistrictRepository districtRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<CriteriaDTO> getCriteriaByEmail(String email, int page, boolean bool) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (bool) {
                Page<Criteria> criteriaPage = criteriaRepository.findAllByUser(user.get(), PageRequest.of(page, 10, Sort.by("createAt").descending()));
                return criteriaPage.map(this::criteriaToCriteriaDTO);
            } else {
                Page<Criteria> criteriaPage = criteriaRepository.findAllByUserAndStop(user.get(), false, PageRequest.of(page, 10, Sort.by("createAt").descending()));
                return criteriaPage.map(this::criteriaToCriteriaDTO);
            }
        } else {
            throw new UserException("Không tìm thấy user " + user.get().getEmail());
        }
    }

    @Override
    public CriteriaDTO createCriteria(CriteriaDTO criteriaDTO, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Optional<District> district = districtRepository.findById(criteriaDTO.getDistrictDTO().getId());
            Criteria criteria = modelMapper.map(criteriaDTO, Criteria.class);
            criteria.setUser(user.get());
            criteria.setDistrict(district.get());
            criteria.setCreateAt(LocalDateTime.now());
            criteriaRepository.save(criteria);

            criteriaDTO = criteriaToCriteriaDTO(criteria);
            return criteriaDTO;
        } else {
            throw new UserException("Không tìm thấy user " + user.get().getEmail());
        }
    }

    @Override
    public CriteriaDTO stopCriteria(Long idCriteria) {
        Optional<Criteria> criteria = criteriaRepository.findById(idCriteria);
        if (criteria.isPresent()) {
            criteria.get().setStop(true);
            CriteriaDTO criteriaDTO = modelMapper.map(criteria.get(), CriteriaDTO.class);
            criteriaDTO.setDistrictDTO(modelMapper.map(criteria.get().getDistrict(), DistrictDTO.class));
            return criteriaDTO;
        } else {
            throw new CriteriaException("Không tìm thấy Criteria id " + idCriteria);
        }
    }

    public CriteriaDTO criteriaToCriteriaDTO(Criteria criteria) {
        CriteriaDTO criteriaDTO = modelMapper.map(criteria, CriteriaDTO.class);
        criteriaDTO.setDistrictDTO(modelMapper.map(criteria.getDistrict(), DistrictDTO.class));

        return criteriaDTO;
    }
}
