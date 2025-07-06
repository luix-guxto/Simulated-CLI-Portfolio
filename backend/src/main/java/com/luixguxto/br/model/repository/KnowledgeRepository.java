package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {

    @Query(value = "SELECT * FROM knowledge WHERE id = :id", nativeQuery = true)
    Knowledge getById(@Param("id") Long id);

    @Query(value = "SELECT * FROM knowledge WHERE id IN (SELECT k.id FROM knowledge k " +
            "LEFT JOIN knowledge_category kc ON k.id = kc.knowledge_id " +
            "LEFT JOIN category c ON c.id = kc.category_id " +
            "WHERE c.skill IN :categories)", nativeQuery = true)
    List<Knowledge> findAllByCategory(@Param("categories") List<String> categories);
} 