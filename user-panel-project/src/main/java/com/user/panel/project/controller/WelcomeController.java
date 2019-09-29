package com.user.panel.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/first")
    public String loginMessage(){
        return "first";
    }
	
	@RequestMapping("/login")
    public String login(){
        return "login";
    }
}
