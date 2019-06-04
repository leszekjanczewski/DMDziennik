package org.swdprm.dmdziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.swdprm.dmdziennik.model.Role;
import org.swdprm.dmdziennik.model.User;
import org.swdprm.dmdziennik.repository.RoleRepository;
import org.swdprm.dmdziennik.service.UserService;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/admin")
    public ModelAndView root() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserLogin(principal.getName());
        modelAndView.addObject("user", user);
        modelAndView.addObject("firstName", user.getFirstName());
        modelAndView.addObject("lastName", user.getLastName());
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @GetMapping("/admin/addUser")
    public ModelAndView addUserForm() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        List<Role> roles = roleRepository.findAll();
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/addUser");
        return modelAndView;
    }

    @PostMapping("/admin/addUser")
    public ModelAndView saveAddUser(@ModelAttribute User user, ModelAndView modelAndView) {
        userService.saveUser(user);
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }
}
