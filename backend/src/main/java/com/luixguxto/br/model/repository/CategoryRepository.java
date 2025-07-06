package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category WHERE id = :id", nativeQuery = true)
    Category getById(@Param("id") Long id);
} 