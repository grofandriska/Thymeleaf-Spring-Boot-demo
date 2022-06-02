package com.example.practise.controller;

import com.example.practise.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/messages")
@Controller
public class MessageController {

   private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }
}
