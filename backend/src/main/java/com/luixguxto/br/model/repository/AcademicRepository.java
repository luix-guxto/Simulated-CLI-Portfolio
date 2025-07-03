package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Academic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicRepository extends JpaRepository<Academic,Long> {

    @Query(value = "SELECT *  FROM academic where id = :id", nativeQuery = true)
    Academic getById(@Param("id") Long id);
}
