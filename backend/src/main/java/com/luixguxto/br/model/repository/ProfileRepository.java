package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProfileRepository extends JpaRepository<Profile, Long> {
    @Query(value = "SELECT * FROM profile LIMIT 1", nativeQuery = true)
    Profile getProfile();
}
