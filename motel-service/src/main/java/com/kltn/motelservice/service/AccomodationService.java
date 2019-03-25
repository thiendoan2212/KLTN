package com.kltn.motelservice.service;

import com.kltn.motelservice.model.AccomodationDTO;

public interface AccomodationService {
    AccomodationDTO createAccomodation(AccomodationDTO accomodationDTO);

    AccomodationDTO updateAccomodation(Long id, AccomodationDTO accomodationDTO);

    String deleteAccomodation(Long id);
}
