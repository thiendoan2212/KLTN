package com.kltn.motelservice.config;

import com.kltn.motelservice.entity.Criteria;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.repository.CriteriaRepository;
import com.kltn.motelservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.List;

public class NotificationEventHandler implements ApplicationListener<NotificationEvent> {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public void onApplicationEvent(NotificationEvent notificationEvent) {
        Post post = notificationEvent.getPost();
        List<Criteria> criteriaList = criteriaRepository.findAllByAcreageStartLessThanEqualAndAcreageEndGreaterThanEqualAndPriceStartLessThanEqualAndPriceEndGreaterThanEqualAndDistrict_IdAndMotelAndStop(
                post.getAccomodation().getAcreage(), post.getAccomodation().getAcreage(), post.getAccomodation().getPrice(), post.getAccomodation().getPrice(), post.getAccomodation().getDistrict().getId(), post.getAccomodation().isMotel(), false);
        for (Criteria criteria : criteriaList) {
            notificationService.createNotification(criteria.getUser(), post, criteria);
        }
    }
}
