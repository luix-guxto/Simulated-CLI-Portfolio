package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Language;
import com.luixguxto.br.model.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository){
        this.repository = repository;
    }

    public List<Language> findAll(){
        return repository.findAll();
    }

    public Language findById(Long id){
        return repository.getById(id);
    }
}
