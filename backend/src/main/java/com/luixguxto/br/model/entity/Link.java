package com.luixguxto.br.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "link")
public class Link {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "url", nullable = false, length = 500)
    private String url;
    
    public Link() {}
    
    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
} 