package com.luixguxto.br.model.entity;

import com.luixguxto.br.model.entity.category.Category;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    @Column(name = "company_url")
    private String companyUrl;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "role_pt")
    private String rolePt;

    @Column(name = "role_en")
    private String roleEn;

    private String location;

    @Column(name = "is_current")
    private Boolean isCurrent;

    @Column(name = "description_pt")
    private String descriptionPt;

    @Column(name = "description_en")
    private String descriptionEn;

    @ManyToMany
    @JoinTable(
            name = "work_experience_category",
            joinColumns = @JoinColumn(name = "work_experience_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getRolePt() {
        return rolePt;
    }

    public String getRoleEn() {
        return roleEn;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public String getDescriptionPt() {
        return descriptionPt;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public List<Category> getCategories() {
        return categories;
    }
} 