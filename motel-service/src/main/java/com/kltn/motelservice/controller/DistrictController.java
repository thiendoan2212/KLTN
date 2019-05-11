package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.DistrictDTO;
import com.kltn.motelservice.service.DistrictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {
    @Autowired
    DistrictServiceImpl districtService;

    @GetMapping
    public List<DistrictDTO> getAllDistrict() {
        return districtService.getAllDistrict();
    }
}
