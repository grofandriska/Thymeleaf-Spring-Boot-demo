package com.example.practise.controller;

import com.example.practise.model.Person;
import com.example.practise.service.PersonService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PutMapping("/new")
    public void add(@RequestBody Person person) {
        service.add(person);
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}/remove")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @PostMapping("/{id}/update")
    public Person update(@RequestBody Person person, @PathVariable Long id) {
        return service.update(id, person);
    }
}
