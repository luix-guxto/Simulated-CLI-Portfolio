package com.luixguxto.br.model.entity.category;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skill;

    public Long getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }
}
