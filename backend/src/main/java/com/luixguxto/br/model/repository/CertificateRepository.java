package com.luixguxto.br.model.repository;

import com.luixguxto.br.model.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    @Query(value = "SELECT * FROM certificate WHERE id = :id", nativeQuery = true)
    Certificate getById(@Param("id") Long id);

    @Query(value = "SELECT * FROM certificate WHERE id IN (SELECT cert.id FROM certificate cert " +
            "LEFT JOIN certificate_category cc ON cert.id = cc.certificate_id " +
            "LEFT JOIN category c ON c.id = cc.category_id " +
            "WHERE c.skill IN :categories)", nativeQuery = true)
    List<Certificate> findAllByCategory(@Param("categories") List<String> categories);
} 