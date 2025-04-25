package com.example.springBootCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springBootCrud.model.Customer;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // resolves to src/main/resources/templates/index.html
    }

    // http://localhost:8080/hello?name=Aparna

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            Model model) {
        model.addAttribute("name", name);
        return "home"; // resolves to src/main/resources/templates/hello.html
    }

}
