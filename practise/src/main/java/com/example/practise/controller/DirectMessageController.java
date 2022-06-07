package com.example.practise.controller;

import com.example.practise.model.DirectMessage;
import com.example.practise.service.DirectMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dm")
public class DirectMessageController {

    @Autowired
    private DirectMessageService service;

    public DirectMessageController() {
    }

    public DirectMessageController(DirectMessageService service) {
        this.service = service;
    }

    @PutMapping("/new")
    public void add(@RequestBody DirectMessage directMessage) {
        service.add(directMessage);
    }

    @GetMapping("/id/{id}")
    public DirectMessage get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/all")
    public List<DirectMessage> list() {
        return service.list();
    }

    @PostMapping("/{id}/update")
    public void update(@RequestBody DirectMessage directMessage,@PathVariable Long id) {
        service.update(directMessage, id);
    }

    @DeleteMapping("/{id}/remove")
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }

    @GetMapping("/{id}/received")
    public List<DirectMessage> received(@PathVariable Long id) {
        return service.getDM(id);
    }

}
