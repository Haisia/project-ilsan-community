package cjh.projectilsancommunity.controller;

import cjh.projectilsancommunity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user/signup")
    public String userSignUpForm(){
        return "userSignUp";
    }

    @PostMapping("/user/signup")
    public String userSignUp(@ModelAttribute User user){

        System.out.println("user.toString() = " + user.toString());

        return "redirect:/";
    }
}
