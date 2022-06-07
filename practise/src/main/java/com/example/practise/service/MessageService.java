package com.example.practise.service;
import com.example.practise.model.Message;
import com.example.practise.model.PM;
import com.example.practise.repository.MessageRepository;
import com.example.practise.repository.PMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MessageService {

    @Autowired
    private PMRepository pmRepository;
    //Have to autowire ,otherwise repo will be null
    @Autowired
    private MessageRepository msgRepository;

    public MessageService(PMRepository pmRepository, MessageRepository msgRepository) {
        this.pmRepository = pmRepository;
        this.msgRepository = msgRepository;
    }

    public MessageService() {
    }

    public void add(Message message) {
        msgRepository.save(message);
    }

    public List<Message> list() {
        return msgRepository.findAll();
    }

    public Message get(Long id) {
        return msgRepository.findById(id).get();
    }

    public void remove(Long id) {
        msgRepository.deleteById(id);
    }

    public void update(Message message, Long id) {
        msgRepository.findById(id).map(object -> {
            object.setMessage(message.getMessage());
            return msgRepository.save(object);
        });
    }

    public List<Message> getMessages(Long id) {
        List<PM> result = pmRepository.findAll().stream().filter(x -> x.getPerson_id().equals(id)).collect(Collectors.toList());
        List<Message> temp = msgRepository.findAll();
        List<Message> msgList = new ArrayList<>();
        for (PM pm : result) {
            for (Message msg : temp) {
                if (msg.getId().equals(pm.getMessage_id())) {
                    msgList.add(msg);

                }
            }
        }
        return msgList;
    }
}
