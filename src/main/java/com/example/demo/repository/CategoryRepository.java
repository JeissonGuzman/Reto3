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

    public Category save(Category category){
        return CategoryCrudRepository.save(category);
    }

    public void delete (Category category){
        CategoryCrudRepository.delete(category);
    }

    public Optional<Category> getCategory(int id){
        return CategoryCrudRepository.findById(id);
    }

}
