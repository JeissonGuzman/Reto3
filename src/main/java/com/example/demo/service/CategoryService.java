package com.example.demo.service;


import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;
    public List<Category> getAll(){
        return CategoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return CategoryRepository.getCategory(id) ;
    }

    public Category save(Category category){
        if(category.getIdCategory()==null){
            return CategoryRepository.save(category);
        }else{
            Optional<Category> e = CategoryRepository.getCategory(category.getIdCategory());
            if(e.isPresent()){
                return category;
            }else{
                return CategoryRepository.save(category);
            }
        }
    }

    public boolean delete (int id){
        boolean flag = false;
        Optional<Category> e = CategoryRepository.getCategory(id);
        if(e.isPresent()){
            CategoryRepository.delete(e.get());
            flag = true;
        }

        return flag;
    }

}
