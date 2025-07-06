package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Certificate;
import com.luixguxto.br.model.repository.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    private final CertificateRepository repository;

    public CertificateService(CertificateRepository repository){
        this.repository = repository;
    }

    public List<Certificate> findAll(){
        return repository.findAll();
    }

    public List<Certificate> findAllByCategory(List<String> categories){
        return repository.findAllByCategory(categories);
    }

    public Certificate findById(Long id){
        return repository.getById(id);
    }
} 