package com.jt.ssalMuck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/main")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        System.out.println("model = " + model);
        return "/main";
    }

}
