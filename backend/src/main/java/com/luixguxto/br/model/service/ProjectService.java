package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Project;
import com.luixguxto.br.model.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository){
        this.repository = repository;
    }

    public List<Project> findAll(){
        return repository.findAll();
    }

    public List<Project> findAllByCategory(List<String> categories){
        return repository.findAllByCategory(categories);
    }

    public Project getById(Long id){
        return repository.getById(id);
    }
}
