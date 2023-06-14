package com.spring.security.springSecurity.controller;

import com.spring.security.springSecurity.models.Person;
import com.spring.security.springSecurity.services.PersonService;
import com.spring.security.springSecurity.services.RegistrationService;
import com.spring.security.springSecurity.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AutController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AutController(RegistrationService registrationService,
                         PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;

    }

    //Аутентификация пользователя
    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    //Регистрация пользователя
    @GetMapping("/registration")
    public String registrationPage(Model model){

        Person person = new Person();
        model.addAttribute("person", person);

        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult) {

        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors()){
            return "/auth/registration";}
       registrationService.registration(person);
        return "redirect:/auth/login";
    }


//    @GetMapping("/table")
//    public String taibUser(Model model){
//
//        model.addAttribute("users", personService.getAllPerson());
//        return "auth/table";
//    }



}
