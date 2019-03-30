package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.AccomodationDTO;
import com.kltn.motelservice.model.SearchForm;
import com.kltn.motelservice.service.AccomodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccomodationController {
    @Autowired
    AccomodationServiceImpl accomodationService;

    @GetMapping("/accomodation/search")
    public List<AccomodationDTO> searchAccomodation() {
        return accomodationService.searchAccomodation(true);
    }
}
