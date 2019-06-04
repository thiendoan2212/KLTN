package com.kltn.motelservice.service;

import com.kltn.motelservice.model.CriteriaDTO;
import org.springframework.data.domain.Page;

public interface CriteriaService {
    Page<CriteriaDTO> getCriteriaByEmail(String email, int page);

    CriteriaDTO createCriteria(CriteriaDTO criteriaDTO, String email);

    CriteriaDTO updateCriteria(Long idCriteria, CriteriaDTO criteriaDTO);

    void deleteCriteria(Long idCriteria);
}
