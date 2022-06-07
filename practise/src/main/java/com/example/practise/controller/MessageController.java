package com.example.practise.controller;

import com.example.practise.model.Message;
import com.example.practise.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/messages")
@RestController
public class MessageController {

    private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Message> list() {
        return service.list();
    }

    @PutMapping("/new")
    public void add(@RequestBody Message msg) {
        service.add(msg);
    }

    @GetMapping("/{id}")
    public Message get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}/remove")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @PostMapping("/{id}/update")
    public void update(@RequestBody Message msg, @PathVariable Long id) {
        service.update(msg, id);
    }

    @GetMapping("/{id}/my")
    public List<Message> myList(@PathVariable Long id) {
        return service.getMessages(id);
    }
}
