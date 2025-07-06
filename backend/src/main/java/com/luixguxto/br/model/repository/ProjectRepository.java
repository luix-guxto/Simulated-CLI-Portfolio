package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM project WHERE id = :id", nativeQuery = true)
    Project getById(@Param("id") Long id);

    @Query(value = "SELECT * FROM project WHERE id IN (SELECT p.id FROM project p " +
            "LEFT JOIN project_category pc ON p.id = pc.project_id " +
            "LEFT JOIN category c ON c.id = pc.category_id " +
            "WHERE c.skill IN :categories)", nativeQuery = true)
    List<Project> findAllByCategory(@Param("categories") List<String> categories);
}
