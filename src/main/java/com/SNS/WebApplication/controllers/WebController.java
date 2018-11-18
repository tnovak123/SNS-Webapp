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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private static String title = "Sam's Nail Spa";
    private static String page;
    private static ArrayList<Service> serviceList;
    private static ArrayList<Person> personList;
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
    public String services(@RequestParam(name="serviceIds", required = false) Integer[] serviceIds, Model model)
            //Errors errors)
    {

//        if (errors.hasErrors()){
//            model.addAttribute("title", title);
//            model.addAttribute("page", page);
//            model.addAttribute("services", serviceDAO.findAll());
//            model.addAttribute("errors", errors);
//
//            return "/web/services";
//        }

        if (serviceIds.length > 0) {
            serviceList = new ArrayList<Service>();
            total = 0.00;
            for (Integer service : serviceIds) {
                serviceList.add(serviceDAO.findById(service).get());
                total = total + serviceDAO.findById(service).get().getPrice();
            }
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
    public String staff(Model model,
                        //Errors errors,
                        @RequestParam(name="staff", required = false) Integer staff){

//        if (errors.hasErrors()){
//            model.addAttribute("title", title);
//            model.addAttribute("page", page);
//            model.addAttribute("persons", personDAO.findAll());
//            model.addAttribute("errors", errors);
//
//            return "/web/staff";
//        }

//        System.out.println("*****");
//        System.out.println(staff);
//        System.out.println("****");

        if (staff != null) {
            personList = new ArrayList<Person>();
            personList.add(personDAO.findById(staff).get());
        }

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