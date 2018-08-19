package com.SNS.WebApplication.controllers;


import com.SNS.WebApplication.models.Address;
import com.SNS.WebApplication.models.Person;
import com.SNS.WebApplication.models.PersonType;
import com.SNS.WebApplication.models.Phone;
import com.SNS.WebApplication.models.data.AddressDAO;
import com.SNS.WebApplication.models.data.PersonDAO;
import com.SNS.WebApplication.models.data.PersonTypeDAO;
import com.SNS.WebApplication.models.data.PhoneDAO;
import com.SNS.WebApplication.models.forms.AddPersonAddressPhoneForm;
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

    @Autowired
    PersonDAO personDAO;

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    PhoneDAO phoneDAO;

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

    @RequestMapping(value = "person", method = RequestMethod.GET)
    public String enterPerson(Model model){

        AddPersonAddressPhoneForm form = new AddPersonAddressPhoneForm();

        page = "Edit a Person";
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        model.addAttribute("form", form);
//        model.addAttribute("person", new Person());
//        model.addAttribute("pts", personTypeDAO.findAll());
//        model.addAttribute("address", new Address());
//        model.addAttribute("phone", new Phone());

        return "admin/person";
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public String enterPerson(Model model, @ModelAttribute @Valid Person person,
                              @ModelAttribute @Valid Address address,
                              @ModelAttribute @Valid Phone phone,
                              @ModelAttribute @Valid AddPersonAddressPhoneForm form,
                              Errors errors){

        if(errors.hasErrors()){
            page = "Edit a Person";
            model.addAttribute("title", title);
            model.addAttribute("page", page);
            model.addAttribute("errors", errors);

            return "admin/person";
        }


        personDAO.save(person);
        addressDAO.save(address);
        phoneDAO.save(phone);

        return "admin/person";
    }

    @RequestMapping(value = "person-type", method = RequestMethod.GET)
    public String enterPersonTypes(Model model){

        page = "Edit Person Types";
        model.addAttribute("title",title);
        model.addAttribute("page", page);
        model.addAttribute("persontype", new PersonType());
        model.addAttribute("pts", personTypeDAO.findAll());

        return "admin/person-type";
    }

    @RequestMapping(value = "person-type", method = RequestMethod.POST)
    public String enterPersonType(Model model, @ModelAttribute @Valid PersonType pt, Errors errors){

        if (errors.hasErrors()){
            page = "Edit Person Types";
            model.addAttribute("title",title);
            model.addAttribute("page", page);
            model.addAttribute("errors", errors);

            return "admin/person-type";
        }

        personTypeDAO.save(pt);
        return "admin/person-type";
    }
}