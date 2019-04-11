package com.kltn.motelservice.controller;

import com.kltn.motelservice.service.AccomodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccomodationController {
    @Autowired
    AccomodationServiceImpl accomodationService;

//    @GetMapping("/accomodation/search")
//    public List<AccomodationDTO> searchAccomodation() {
//        return accomodationService.searchAccomodation(true);
//    }
}
