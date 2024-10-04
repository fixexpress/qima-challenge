package com.qima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    @GetMapping("/products")
    public String products() {
        return "products"; 
    }
    

}
