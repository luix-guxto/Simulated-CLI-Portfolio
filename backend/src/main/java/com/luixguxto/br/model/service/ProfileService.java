package com.luixguxto.br.model.service;

import com.luixguxto.br.model.entity.Profile;
import com.luixguxto.br.model.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository){
        this.repository = repository;
    }

    public Profile getProfile(){
        return repository.getProfile();
    }
}
