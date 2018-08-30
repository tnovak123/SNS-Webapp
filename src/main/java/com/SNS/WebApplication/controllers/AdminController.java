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

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    private static String title = "Administrate Sam's Nail Spa";
    private static String page;

    @Autowired
    PersonTypeDAO personTypeDAO;

    @Autowired
    PersonDAO personDAO;

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    PhoneDAO phoneDAO;

    @Autowired
    RewardValueDAO rewardValueDAO;

    @Autowired
    ServiceDAO serviceDAO;

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
        model.addAttribute("service", new Service());
        model.addAttribute("rvs", rewardValueDAO.findAll());

        return "admin/services";
    }

    @RequestMapping(value = "services", method = RequestMethod.POST)
    public String services(Model model, @ModelAttribute @Valid Service service, @RequestParam Integer rvId, Errors errors){

        page = "Service Entry Page";
        if (errors.hasErrors()){
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("errors", errors);
            model.addAttribute("rvs", rewardValueDAO.findAll());

            return "admin/services";
        }

        service.setRewardValue(rewardValueDAO.findById(rvId).get());
        serviceDAO.save(service);

        return "admin/services";
    }

    @RequestMapping(value = "reward-value", method = RequestMethod.GET)
    public String editRewardsValues(Model model){

        page = "Edit Rewards Values";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("rv1", new RewardValue());
        model.addAttribute("rvs", rewardValueDAO.findAll());

        return "reward-value";
    }

    @RequestMapping(value = "reward-value", method = RequestMethod.POST)
    public String editRewardsValues(Model model, @ModelAttribute @Valid RewardValue rv, Errors errors){

        if (errors.hasErrors()){
            page = "Edit Rewards Values";
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("rvs", rewardValueDAO.findAll());
            model.addAttribute("errors", errors);

            return "reward-value";
        }

        rewardValueDAO.save(rv);

        model.addAttribute("rvs", rewardValueDAO.findAll());

        return "reward-value";
    }

    @RequestMapping(value = "person", method = RequestMethod.GET)
    public String enterPerson(Model model){


        page = "Edit a Person";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("person", new Person());
        model.addAttribute("personTypes", personTypeDAO.findAll());
        model.addAttribute("address", new Address());
        model.addAttribute("phone", new Phone());

        return "admin/person";
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public String enterPerson(Model model, @ModelAttribute @Valid Person person,
                              @ModelAttribute @Valid Address address,
                              @ModelAttribute @Valid Phone phone,
                              @RequestParam Integer typeId,
                              Errors errors){

        if(errors.hasErrors()){
            page = "Edit a Person";
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("errors", errors);

            return "admin/person";
        }

        person.setType(personTypeDAO.findById(typeId).get());
        personDAO.save(person);
        address.setPerson(person);
        phone.setPerson(person);

        addressDAO.save(address);
        phoneDAO.save(phone);

        return "admin/person";
    }

    @RequestMapping(value = "person-type", method = RequestMethod.GET)
    public String enterPersonTypes(Model model){

        page = "Edit Person Types";
        model.addAttribute("title",title);
        model.addAttribute("page", page);
        model.addAttribute("personType", new PersonType());
        model.addAttribute("pts", personTypeDAO.findAll());

        return "admin/person-type";
    }

    @RequestMapping(value = "person-type", method = RequestMethod.POST)
    public String enterPersonType(Model model, @ModelAttribute @Valid PersonType pt, Errors errors){

        if (errors.hasErrors()){
            page = "Edit Person Types";
            model.addAttribute("title",title);
            model.addAttribute("page", page);
            model.addAttribute("pts", personTypeDAO.findAll());
            model.addAttribute("errors", errors);

            return "admin/person-type";
        }

        personTypeDAO.save(pt);

        model.addAttribute("pts", personTypeDAO.findAll());

        return "admin/person-type";
    }
}