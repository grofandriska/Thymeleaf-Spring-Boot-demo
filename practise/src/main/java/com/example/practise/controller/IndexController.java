package com.example.practise.controller;

import com.example.practise.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    PersonService personService;

    public IndexController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", personService.list());
        return "index";
    }

    @GetMapping("/styled-page")
    public String getStyledPage(Model model , Model list) {
        model.addAttribute("name", personService.list().get(1).getName());
        list.addAttribute("list", personService.list());
        return "index";
    }
}
