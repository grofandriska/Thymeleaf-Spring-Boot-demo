package com.example.practise.controller;

import com.example.practise.model.Person;
import com.example.practise.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping(value = "/id/{id}",method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        service.addPerson();
        Person result = service.getPerson(id) ;
        System.out.println(result.toString());
        model.addAttribute("result",result) ;
        return "index" ;
    }
    @PostMapping("/new")
    public void add() {
        service.addPerson();
    }
}
