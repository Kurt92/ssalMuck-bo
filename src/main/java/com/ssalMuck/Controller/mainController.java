package com.ssalMuck.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        System.out.println("model = " + model);
        return "/";
    }

}
