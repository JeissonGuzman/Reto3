package com.example.demo.controller;


import com.example.demo.entities.Score;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService ScoreService;

    @GetMapping("/all")
    public List<Score>getAll(){
        return ScoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save( @RequestBody Score score){
        return ScoreService.save(score);
    }

}
