package com.rentacar.controller;

import com.rentacar.dto.UserDto;
import com.rentacar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping(path = "/")
    public String main() {
        return "home";
    }

    @GetMapping(path = "/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user",new UserDto());
        return "sign-up";
    }

    @PostMapping(path = "/sign-up")
    public String saveUser(@ModelAttribute("user") UserDto user) {
        userService.save(user);
        return "redirect:/login";
    }
}
