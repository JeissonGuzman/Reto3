package com.example.demo.service;


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

    public boolean delete (int id){
        boolean flag = false;
        Optional<Message> e = MessageRepository.getMessage(id);
        if(e.isPresent()){
            MessageRepository.delete(e.get());
            flag = true;
        }

        return flag;
    }

}
