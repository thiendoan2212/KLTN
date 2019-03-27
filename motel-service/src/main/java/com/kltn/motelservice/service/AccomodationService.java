package com.kltn.motelservice.service;

import com.kltn.motelservice.model.AccomodationDTO;

import java.util.List;

public interface AccomodationService {
    List<AccomodationDTO> searchAccomodation(double acreageMin, double acreageMax, double priceMin,
                                             double priceMax, boolean isMotel, Long idDistrict);
}
