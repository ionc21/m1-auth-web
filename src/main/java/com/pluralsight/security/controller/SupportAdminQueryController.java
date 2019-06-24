package com.pluralsight.security.controller;

import com.pluralsight.security.service.SupportQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class SupportAdminQueryController {

    private final SupportQueryService supportQueryService;

    @GetMapping("/support/admin")
    public ModelAndView getSupportQueries() {
        return new ModelAndView("support", "queries", supportQueryService.getSupportQueriesForAllUsers());
    }

}
