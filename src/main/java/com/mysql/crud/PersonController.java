package com.mysql.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {


    @Autowired
    public PersonRepository repository;

    @GetMapping("/")
    public String test(){
        return "test";
    }

    @GetMapping("/form")
    public String addPerson(Model model){
        model.addAttribute("person", new Person());
        return "addForm";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person){
        repository.save(person);
        return "redirect:/listAllPerson";
    }

    @GetMapping("/listAllPerson")
    public String getAllPersons(Model model){
        model.addAttribute("persons", repository.findAll());
        return "list";
    }
}
