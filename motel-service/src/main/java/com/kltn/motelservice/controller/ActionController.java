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
@RequestMapping("/api")
@PreAuthorize("#oauth2.hasAnyScope('read')")
public class ActionController {
    @Autowired
    ActionServiceImpl actionService;

    @GetMapping("/actions")
    public Page<ActionDTO> getAction(@RequestParam int page) {
        return actionService.getAction(page);
    }
}
