package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Knowledge;
import com.luixguxto.br.model.repository.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeService {
    private final KnowledgeRepository repository;

    public KnowledgeService(KnowledgeRepository repository){
        this.repository = repository;
    }

    public List<Knowledge> findAll(){
        return repository.findAll();
    }

    public List<Knowledge> findAllByCategory(List<String> categories){
        return repository.findAllByCategory(categories);
    }

    public Knowledge findById(Long id){
        return repository.getById(id);
    }
} 