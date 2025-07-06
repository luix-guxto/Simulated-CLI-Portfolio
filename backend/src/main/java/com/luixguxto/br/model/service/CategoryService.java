package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.category.Category;
import com.luixguxto.br.model.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.getById(id);
    }
} 