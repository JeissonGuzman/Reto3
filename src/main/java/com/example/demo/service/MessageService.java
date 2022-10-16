package com.example.demo.service;


import com.example.demo.entities.Category;
import com.example.demo.entities.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository MessageRepository;
    public List<Message> getAll(){
        return MessageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return MessageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return MessageRepository.save(message);
        }else{
            Optional<Message> e = MessageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return MessageRepository.save(message);
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> old=MessageRepository.getMessage(message.getIdMessage());
            if(old.isPresent()){
                Message k=old.get();
                if(message.getMessageText()!=null){
                    k.setMessageText(message.getMessageText());
                }
                return MessageRepository.save(k);
            }
        }
        return message;
    }

    public boolean deleteMessage (int id){
        Boolean d = getMessage(id).map(message -> {
            MessageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }

}
