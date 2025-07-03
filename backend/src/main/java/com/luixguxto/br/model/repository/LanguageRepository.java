package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    @Query(value = "SELECT * FROM language WHERE id = :id",nativeQuery = true)
    Language getById(@Param("id") Long id);
}
