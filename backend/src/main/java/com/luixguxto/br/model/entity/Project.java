package com.luixguxto.br.model.entity;

import com.luixguxto.br.model.entity.category.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_pt")
    private String namePt;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "description_pt")
    private String descriptionPt;

    @Column(name = "description_en")
    private String descriptionEn;

    private String url;

    @ManyToMany
    @JoinTable(
            name = "project_category",
            joinColumns = @JoinColumn(name = "project_id"),
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

    public String getDescriptionPt() {
        return descriptionPt;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getUrl() {
        return url;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
