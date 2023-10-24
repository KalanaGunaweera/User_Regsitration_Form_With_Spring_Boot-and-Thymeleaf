package com.User_Regsitration_Form.controller;

import com.User_Regsitration_Form.entity.User;
import com.User_Regsitration_Form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("message", "Submitted Successfully");
        return "register";
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("user", listOfUsers);
        return "user";
    }

//    @Autowired
//    UserRepository userRepository;

//    @GetMapping("/registration")
//    public String getRegPage(@ModelAttribute("user") User user) {
//        return "register";
//    }

//    @PostMapping("/registration")
//    public String saveUser(@ModelAttribute("user") User user, Model model) {
//        userRepository.save(user);
//        model.addAttribute("message", "Submitted Successfully");
//        return "register";
//    }
//
//    @GetMapping("/users")
//    public String usersPage(Model model) {
//        List<User> listOfUsers = userRepository.findAll();
//        model.addAttribute("user", listOfUsers);
//        return "user";
//    }





}
