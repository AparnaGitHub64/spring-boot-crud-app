package com.example.springBootCrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index"; // This should return the name of your home view (e.g., home.html or home.jsp)
    }

    
}
