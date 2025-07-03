package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.Language;
import com.luixguxto.br.util.enums.Level;

public class LanguageLang {

    private Long id;
    private String name;
    private Level levelReading;
    private Level levelWriting;
    private Level levelSpeaking;
    private String lang;

    public LanguageLang(Language l, String lang){
        this.id = l.getId();
        this.name = lang.equals("pt") ? l.getNamePt() : l.getNameEn();
        this.levelReading = l.getLevelReading();
        this.levelSpeaking = l.getLevelSpeaking();
        this.levelWriting = l.getLevelWriting();
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevelReading() {
        return levelReading;
    }

    public void setLevelReading(Level levelReading) {
        this.levelReading = levelReading;
    }

    public Level getLevelWriting() {
        return levelWriting;
    }

    public void setLevelWriting(Level levelWriting) {
        this.levelWriting = levelWriting;
    }

    public Level getLevelSpeaking() {
        return levelSpeaking;
    }

    public void setLevelSpeaking(Level levelSpeaking) {
        this.levelSpeaking = levelSpeaking;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Idiomas =====================================\\n" +
                    "ID           : " + id + "\\n" +
                    "Idioma       : " + name + "\\n" +
                    "Leitura      : " + levelReading + "\\n" +
                    "Escrita      : " + levelWriting + "\\n" +
                    "Conversação  : " + levelSpeaking + "\\n" +
                    "==================================================";
        } else {
            return "=== Languages ===================================\\n" +
                    "ID           : " + id + "\\n" +
                    "Language     : " + name + "\\n" +
                    "Reading      : " + levelReading + "\\n" +
                    "Writing      : " + levelWriting + "\\n" +
                    "Speaking     : " + levelSpeaking + "\\n" +
                    "==================================================";
        }
    }
}
