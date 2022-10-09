package com.example.demo.repository;

import com.example.demo.entities.Message;
import com.example.demo.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository MessageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) MessageCrudRepository.findAll();
    }

    public Message save(Message message){
        return MessageCrudRepository.save(message);
    }

    public void delete (Message message){
        MessageCrudRepository.delete(message);
    }

    public Optional<Message> getMessage(int id){
        return MessageCrudRepository.findById(id);
    }

}
