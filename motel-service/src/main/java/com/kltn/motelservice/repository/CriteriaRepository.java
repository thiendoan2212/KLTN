package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Criteria;
import com.kltn.motelservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
    List<Criteria> findAllByAcreageStartLessThanEqualAndAcreageEndGreaterThanEqualAndPriceStartLessThanEqualAndPriceEndGreaterThanEqualAndDistrict_IdAndMotelAndStopAndUserNot(
            double acreageStart, double acreageEnd, double priceStart, double priceEnd, long idDistrict, boolean motel, boolean stop, User user);

    Page<Criteria> findAllByUser(User user, Pageable pageable);

    Page<Criteria> findAllByUserAndStop(User user, boolean stop, Pageable pageable);
}
