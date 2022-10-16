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
        if(category.getId()==null){
            return CategoryRepository.save(category);
        }else{
            Optional<Category> e = CategoryRepository.getCategory(category.getId());
            if(e.isPresent()){
                return category;
            }else{
                return CategoryRepository.save(category);
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> old=CategoryRepository.getCategory(category.getId());
            if(old.isPresent()){
                Category k=old.get();
                if(category.getName()!=null){
                    k.setName(category.getName());
                }
                if(category.getDescription()!=null){
                    k.setDescription(category.getDescription());
                }
                return CategoryRepository.save(k);
            }
        }
        return category;
    }

    public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {
            CategoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
