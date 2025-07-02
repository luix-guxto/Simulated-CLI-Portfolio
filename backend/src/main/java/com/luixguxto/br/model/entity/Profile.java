package com.luixguxto.br.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "title_pt")
    private String titlePt;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "bio_pt")
    private String bioPt;

    @Column(name = "bio_en")
    private String bioEn;

    private String email;
    private String phone;
    private String location;
    private String linkedin;
    private String github;

    @Column(name = "cv_pt_url")
    private String urlCvPt;

    @Column(name = "cv_en_url")
    private String urlCvEn;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitlePt() {
        return titlePt;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getBioPt() {
        return bioPt;
    }

    public String getBioEn() {
        return bioEn;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }

    public String getUrlCvPt() {
        return urlCvPt;
    }

    public String getUrlCvEn() {
        return urlCvEn;
    }
}
