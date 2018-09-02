package com.SNS.WebApplication.controllers;


import com.SNS.WebApplication.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web")
public class WebController {

    private static String title = "Sam's Nail Spa";
    private static String page;

    @Autowired
    ServiceDAO serviceDAO;

    @Autowired
    RewardValueDAO rewardValueDAO;

    @Autowired
    PersonDAO personDAO;

    @Autowired
    PersonTypeDAO personTypeDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        page = "Sam's Nail Spa";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "/web/index";
    }

    @RequestMapping(value = "services", method = RequestMethod.GET)
    public String services(Model model){

        page = "Services Available";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("services", serviceDAO.findAll());

        return "/web/services";
    }

    @RequestMapping(value = "staff", method = RequestMethod.GET)
    public String staff(Model model){

        page = "Available Staff";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("persons", personDAO.findDistinctPersonByType(personTypeDAO.findById(1).get()));

        return "/web/staff";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(Model model){

        page = "About Sam's Nail Spa";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "/web/about";
    }
}