package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

    @Query(value = "SELECT * FROM work_experience WHERE id = :id", nativeQuery = true)
    WorkExperience getById(@Param("id") Long id);

    @Query(value = "SELECT * FROM work_experience WHERE id IN (SELECT we.id FROM work_experience we " +
            "LEFT JOIN work_experience_category wec ON we.id = wec.work_experience_id " +
            "LEFT JOIN category c ON c.id = wec.category_id " +
            "WHERE c.skill IN :categories)", nativeQuery = true)
    List<WorkExperience> findAllByCategory(@Param("categories") List<String> categories);
} 