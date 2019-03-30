package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Accomodation;
import com.kltn.motelservice.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
    //    List<Accomodation> findAccomodationByAcreageBetweenAndPriceBetweenAndMotelAndDistrict(double acreageStart, double acreage, double priceMin,
//                                                                                          double priceMax, boolean isMotel, District district);
//    List<Accomodation> findAccomodationByAcreageBetween(double acreageStart, double acreageEnd);

//    List<Accomodation> findAccomodationsByAcreageBetweenAndMotelAndDistrict(double acreageStart, double acreage, @Param("Motel") boolean isMotel, @Param("District") District district);
    List<Accomodation> findAllByStatus(boolean bool);

}
