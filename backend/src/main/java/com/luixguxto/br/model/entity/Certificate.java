package com.luixguxto.br.model.entity;

import com.luixguxto.br.model.entity.category.Category;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_pt")
    private String namePt;

    @Column(name = "name_en")
    private String nameEn;

    private String organization;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "description_pt")
    private String descriptionPt;

    @Column(name = "description_en")
    private String descriptionEn;

    private String code;

    private String url;

    @ManyToMany
    @JoinTable(
            name = "certificate_category",
            joinColumns = @JoinColumn(name = "certificate_id"),
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

    public String getOrganization() {
        return organization;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getDescriptionPt() {
        return descriptionPt;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public List<Category> getCategories() {
        return categories;
    }
} 