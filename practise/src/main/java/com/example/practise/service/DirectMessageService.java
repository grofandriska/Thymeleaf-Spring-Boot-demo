package com.example.practise.service;

import com.example.practise.model.DirectMessage;
import com.example.practise.repository.DirectMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectMessageService {

    @Autowired
    private DirectMessageRepository repository;

    public DirectMessageService() {
    }

    public DirectMessageService(DirectMessageRepository repository) {
        this.repository = repository;
    }

    public void add(DirectMessage directMessage) {
        repository.save(directMessage);
    }

    public DirectMessage get(Long id) {
        return repository.findById(id).get();
    }

    public List<DirectMessage> list() {
        return repository.findAll();
    }

    public void update(DirectMessage directMessage, Long id) {
        repository.findById(id).map(obj -> {
            obj.setMessage(directMessage.getMessage());
            return repository.save(obj);
        });
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<DirectMessage> getDM(Long id) {
        List<DirectMessage> result = repository.findAll().stream().filter(x -> x.getReceiver_id().equals(id)).collect(Collectors.toList());
        return result;
    }

}
