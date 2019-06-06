package org.swdprm.dmdziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.swdprm.dmdziennik.model.Role;
import org.swdprm.dmdziennik.model.User;
import org.swdprm.dmdziennik.repository.RoleRepository;
import org.swdprm.dmdziennik.repository.UserRepository;
import org.swdprm.dmdziennik.service.RoleService;
import org.swdprm.dmdziennik.service.UserService;

import java.util.List;
import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/admin")
    public ModelAndView root(ModelAndView modelAndView) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserLogin(principal.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @GetMapping("/admin/addUser")
    public ModelAndView addUserForm(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.addObject("roles", roleRepository.findAll());
        modelAndView.setViewName("admin/addUser");
        return modelAndView;
    }

    @PostMapping("/admin/addUser")
    public ModelAndView saveAddUser(@ModelAttribute User user, ModelAndView modelAndView) {
        userService.saveUser(user);
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @GetMapping("/admin/addRole")
    public ModelAndView addRoleForm() {
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("admin/addRole");
        return modelAndView;
    }

    @PostMapping("/admin/addRole")
    public String saveRole(@ModelAttribute Role role, ModelAndView modelAndView) {
        roleService.saveRole(role);
        return "redirect:/admin/userList";
    }

    @GetMapping("/admin/userList")
    public ModelAndView showAllUser(ModelAndView modelAndView) {
        modelAndView.addObject("users", userRepository.findAll());
        modelAndView.setViewName("/admin/userList");
        return modelAndView;
    }

    @GetMapping("/admin/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        userRepository.delete(userRepository.findUserById(id));
        return "redirect:/admin/userList";
    }

    @GetMapping("/admin/editUser/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user, Model model) {
        user = userRepository.findUserById(id);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "/admin/editUser";
    }

    @PostMapping("/admin/editUser")
    public String updateUser(@ModelAttribute User user) {
        //TODO: UPDATE User
        return "redirec:/admin/userList";
    }
}
