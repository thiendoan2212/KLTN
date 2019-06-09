package com.kltn.motelservice.config;

import com.kltn.motelservice.entity.Criteria;
import com.kltn.motelservice.entity.NotificationName;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.repository.CriteriaRepository;
import com.kltn.motelservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationEventHandler implements ApplicationListener<NotificationEvent> {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public void onApplicationEvent(NotificationEvent notificationEvent) {
        Post post = notificationEvent.getPost();
        if (post.isApproved()) {
            List<Criteria> criteriaList = criteriaRepository.findAllByAcreageStartLessThanEqualAndAcreageEndGreaterThanEqualAndPriceStartLessThanEqualAndPriceEndGreaterThanEqualAndDistrict_IdAndMotelAndStopAndUserNot(
                    post.getAccomodation().getAcreage(), post.getAccomodation().getAcreage(), post.getAccomodation().getPrice(), post.getAccomodation().getPrice(), post.getAccomodation().getDistrict().getId(), post.getAccomodation().isMotel(), false, post.getUser());
            for (Criteria criteria : criteriaList) {
                notificationService.createNotification(criteria.getUser(), post, criteria, NotificationName.NOTIFICATION);
            }
            notificationService.createNotification(post.getUser(), post, null, NotificationName.APPROVE);
        } else {
            notificationService.createNotification(post.getUser(), post, null, NotificationName.BLOCK);
        }
    }
}
