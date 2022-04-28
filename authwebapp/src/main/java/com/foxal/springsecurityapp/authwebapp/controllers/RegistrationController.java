package com.foxal.springsecurityapp.authwebapp.controllers;

import com.foxal.springsecurityapp.authwebapp.models.Role;
import com.foxal.springsecurityapp.authwebapp.models.User;
import com.foxal.springsecurityapp.authwebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        if(userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername()))
            return "signup_form";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles(Collections.singleton(Role.USER));

        userRepository.save(user);

        return "register_success";
    }
}
