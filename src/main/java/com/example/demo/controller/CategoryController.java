package com.example.demo.controller;


import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;

    @GetMapping("/all")
    public List<Category>getAll(){
        return CategoryService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save( @RequestBody Category category){
        return CategoryService.save(category);
    }

}
