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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private static String title = "Sam's Nail Spa";
    private static String page;
    private static List<Service> serviceList;
    private static List<Person> personList;
    private static Double total;


    @Autowired
    ServiceDAO serviceDAO;

    @Autowired
    RewardValueDAO rewardValueDAO;

    @Autowired
    PersonDAO personDAO;

    @Autowired
    PersonTypeDAO personTypeDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){

        page = "Sam's Nail Spa";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "/web/index";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(Model model){

        page = "Services Available";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("services", serviceDAO.findAll());

        return "/web/services";
    }

    @RequestMapping(value = "/services", method = RequestMethod.POST)
    public String services(Model model, @RequestParam(required = false) Integer[] serviceIds, Errors errors){

        if (errors.hasErrors()){
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("services", serviceDAO.findAll());
            model.addAttribute("errors", errors);

            return "/web/services";
        }

        for (Integer service : serviceIds) {
            serviceList.add(serviceDAO.findById(service).get());
            total = total + serviceDAO.findById(service).get().getPrice();
        }

        return "redirect:/web/staff";
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public String staff(Model model){

        page = "Available Staff";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("persons", personDAO.findDistinctPersonByType(personTypeDAO.findById(1).get()));

        return "/web/staff";
    }

    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public String staff(Model model, @RequestParam Integer selection, Errors errors){

        if (errors.hasErrors()){
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("persons", personDAO.findAll());
            model.addAttribute("errors", errors);

            return "/web/staff";
        }

        personList.add(personDAO.findById(selection).get());

        return "redirect:/web/checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(Model model){

        page = "Your Order";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("services", serviceList);
        model.addAttribute("staff", personList.get(0));
        model.addAttribute("total", total);

        return "/web/checkout";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model){

        page = "About Sam's Nail Spa";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "/web/about";
    }
}