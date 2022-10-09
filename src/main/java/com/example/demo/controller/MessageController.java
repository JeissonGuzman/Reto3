package com.example.demo.controller;


import com.example.demo.entities.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService MessageService;

    @GetMapping("/all")
    public List<Message>getAll(){
        return MessageService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save( @RequestBody Message message){
        return MessageService.save(message);
    }

}
