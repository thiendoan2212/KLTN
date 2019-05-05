package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.ActionName;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.ActionDTO;
import org.springframework.data.domain.Page;

public interface ActionService {
    void createAction(Post post, User user, ActionName actionName);

    Page<ActionDTO> getAction(int age);

    Page<ActionDTO> getActionByApprover(Long id, int page);
}
