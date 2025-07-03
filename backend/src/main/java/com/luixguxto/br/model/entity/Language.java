package com.luixguxto.br.model.entity;

import com.luixguxto.br.util.enums.Level;
import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_pt")
    private String namePt;

    @Column(name = "name_en")
    private String nameEn;

    @Enumerated(EnumType.STRING)
    @Column(name = "level_reading")
    private Level levelReading;

    @Enumerated(EnumType.STRING)
    @Column(name = "level_writing")
    private Level levelWriting;

    @Enumerated(EnumType.STRING)
    @Column(name = "level_speaking")
    private Level levelSpeaking;

    public Long getId() {
        return id;
    }

    public String getNamePt() {
        return namePt;
    }

    public String getNameEn() {
        return nameEn;
    }

    public Level getLevelReading() {
        return levelReading;
    }

    public Level getLevelWriting() {
        return levelWriting;
    }

    public Level getLevelSpeaking() {
        return levelSpeaking;
    }
}
