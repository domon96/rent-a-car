package com.rentacar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String main() {
        return "home";
    }

    @GetMapping(path = "/sign-up")
    public String signUp() {
        return "sign-up";
    }
}
