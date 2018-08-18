package com.SNS.WebApplication.controllers;


import com.SNS.WebApplication.models.PersonType;
import com.SNS.WebApplication.models.data.PersonTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    private static String title = "Administrate Sam's Nail Spa";
    private static String page;

    @Autowired
    PersonTypeDAO personTypeDAO;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model){

        page = "Start Page for Administrator";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "admin/index";
    }

    @RequestMapping(value = "services", method = RequestMethod.GET)
    public String services(Model model){

        page = "Service Entry Page";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "admin/services";
    }

    @RequestMapping(value = "reward-values", method = RequestMethod.GET)
    public String editRewardsValues(Model model){

        page = "Edit Rewards Values";
        model.addAttribute("title", title);
        model.addAttribute("page", page);

        return "reward-values";
    }

    @RequestMapping(value = "person-type", method = RequestMethod.GET)
    public String enterPersonTypes(Model model){

        page = "Edit Person Types";
        model.addAttribute("title",title);
        model.addAttribute("page", page);

        return "admin/person-type";
    }

    @RequestMapping(value = "persontype", method = RequestMethod.POST)
    public String enterPersonType(Model model, @ModelAttribute @Valid PersonType pt, Errors errors){

        if (errors.hasErrors()){
            page = "Edit Person Types";
            model.addAttribute("title",title);
            model.addAttribute("page", page);
            model.addAttribute("errors", errors);

            return "person-type";
        }

        personTypeDAO.save(pt);
        return "redirect:";
    }
}