package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Link;
import com.luixguxto.br.model.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    
    private final LinkRepository repository;
    
    @Autowired
    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }
    
    public Optional<Link> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }
} 