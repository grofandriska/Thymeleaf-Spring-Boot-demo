package com.example.practise.service;

import com.example.practise.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private List<Message> messageList ;

    public MessageService() {
    }

    public MessageService(List<Message> messageList) {
        this.messageList = messageList;
    }
}
