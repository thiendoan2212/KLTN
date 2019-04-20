package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Action;
import com.kltn.motelservice.entity.ActionName;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.ActionDTO;
import com.kltn.motelservice.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionRepository actionRepository;

    @Override
    public void createAction(Post post, User user, ActionName actionName) {
        Action action = new Action(user, post, actionName, LocalDateTime.now());
        actionRepository.save(action);
    }

    @Override
    public Page<ActionDTO> getAction(int page) {
        Page<Action> actionPage = actionRepository.findAll(PageRequest.of(page, 20, Sort.by("time").ascending()));
        Page<ActionDTO> actionDTOPage = actionPage.map(action ->
                new ActionDTO(action.getId(), action.getUser().getUsername(), action.getAction(), action.getPost().getTitle(), action.getId())
        );
        return actionDTOPage;
    }
}
