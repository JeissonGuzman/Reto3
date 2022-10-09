package com.example.demo.repository;

import com.example.demo.entities.Category;
import com.example.demo.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository CategoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) CategoryCrudRepository.findAll();
    }

    public Category save(Category m){
        return CategoryCrudRepository.save(m);
    }

    public void delete (Category m){
        CategoryCrudRepository.delete(m);
    }

    public Optional<Category> getCategory(int id){
        return CategoryCrudRepository.findById(id);
    }

}
