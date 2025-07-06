package com.luixguxto.br.model.entity;

import com.luixguxto.br.model.entity.category.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "knowledge")
public class Knowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_pt")
    private String namePt;

    @Column(name = "name_en")
    private String nameEn;

    private String level;

    private String url;

    @ManyToMany
    @JoinTable(
            name = "knowledge_category",
            joinColumns = @JoinColumn(name = "knowledge_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;

    public Long getId() {
        return id;
    }

    public String getNamePt() {
        return namePt;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getLevel() {
        return level;
    }

    public String getUrl() {
        return url;
    }

    public List<Category> getCategories() {
        return categories;
    }
} 