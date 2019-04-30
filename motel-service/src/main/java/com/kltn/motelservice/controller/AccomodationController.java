package com.kltn.motelservice.controller;

import com.kltn.motelservice.service.AccomodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@PreAuthorize("#oauth2.hasAnyScope('read')")
public class AccomodationController {
    @Autowired
    AccomodationServiceImpl accomodationService;

//    @GetMapping("/accomodation/search")
//    public List<AccomodationDTO> searchAccomodation() {
//        return accomodationService.searchAccomodation(true);
//    }
}
