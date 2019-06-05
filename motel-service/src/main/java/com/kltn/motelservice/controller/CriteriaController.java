package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.CriteriaDTO;
import com.kltn.motelservice.service.CriteriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CriteriaController {
    @Autowired
    CriteriaServiceImpl criteriaService;

    @GetMapping("/criterias")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public Page<CriteriaDTO> getCriteriaByEmail(OAuth2Authentication auth, @RequestParam("page") int page) {
        return criteriaService.getCriteriaByEmail(auth.getName(), page);
    }

    @PostMapping("/criteria")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CriteriaDTO createCriteria(OAuth2Authentication auth, @RequestBody CriteriaDTO criteriaDTO) {
        return criteriaService.createCriteria(criteriaDTO, auth.getName());
    }

    @PutMapping("/criteria/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CriteriaDTO stopCriteria(@PathVariable Long id){
        return criteriaService.stopCriteria(id);
    }

}
