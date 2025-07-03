package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Academic;
import com.luixguxto.br.model.repository.AcademicRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcademicService {

    private final AcademicRepository repository;

    public AcademicService(AcademicRepository repository){
        this.repository = repository;
    }

    public List<Academic> findAll(){
        return repository.findAll();
    }

    public Academic findById(Long id){
        return repository.getById(id);
    }
}
