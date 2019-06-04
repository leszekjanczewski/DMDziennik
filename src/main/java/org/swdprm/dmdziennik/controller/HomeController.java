package org.swdprm.dmdziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.swdprm.dmdziennik.model.User;
import org.swdprm.dmdziennik.service.UserService;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
/*
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserLogin(principal.getName());
        modelAndView.addObject("user", user);
*/
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
