package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.ActionDTO;
import com.kltn.motelservice.service.ActionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actions")
@PreAuthorize("#oauth2.hasAnyScope('read')")
public class ActionController {
    @Autowired
    ActionServiceImpl actionService;

    @GetMapping
    public Page<ActionDTO> getAction(@RequestParam int page, @RequestParam(required = false, defaultValue = "-1") Long id) {
       if(id.equals(-1l))
           return actionService.getAction(page);
       else
           return actionService.getActionByApprover(id, page);
    }
}
