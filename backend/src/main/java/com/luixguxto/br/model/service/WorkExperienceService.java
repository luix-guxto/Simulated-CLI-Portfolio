package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.WorkExperience;
import com.luixguxto.br.model.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService {
    private final WorkExperienceRepository repository;

    public WorkExperienceService(WorkExperienceRepository repository){
        this.repository = repository;
    }

    public List<WorkExperience> findAll(){
        return repository.findAll();
    }

    public List<WorkExperience> findAllByCategory(List<String> categories){
        return repository.findAllByCategory(categories);
    }

    public WorkExperience findById(Long id){
        return repository.getById(id);
    }
} 