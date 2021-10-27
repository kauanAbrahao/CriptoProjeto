package com.example.CriptoProjeto.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeBusiness {

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }


}
