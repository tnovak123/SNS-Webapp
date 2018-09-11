package com.SNS.WebApplication.controllers;

import com.SNS.WebApplication.models.*;
import com.SNS.WebApplication.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private String page;

    @Autowired
    private PersonDAO personDAO;

    

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model){

        page = "Login to Sam's Nail Salon";
        model.addAttribute("title", "Login Sam's Nail Salon");
        model.addAttribute("page", page);
        model.addAttribute("user", new User());

        return ("/user/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute @Valid User user, Errors errors){

        if (errors.hasErrors()){
            page = "Login to Sam's Nail Salon";
            model.addAttribute("title", "Login Sam's Nail Salon");
            model.addAttribute("page", page);
            model.addAttribute("user", user);
            model.addAttribute("errors", errors);

            return ("/user/index");
        }


    }

}
