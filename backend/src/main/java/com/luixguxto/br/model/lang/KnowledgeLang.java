package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.Knowledge;
import com.luixguxto.br.model.entity.category.Category;

import java.util.List;

public class KnowledgeLang {

    private Long id;
    private String name;
    private String level;
    private String url;
    private final List<Category> categorySet;
    private String lang;

    public KnowledgeLang(Knowledge k, String lang){
        this.lang = lang;
        this.id = k.getId();
        this.level = k.getLevel();
        this.url = k.getUrl();
        this.categorySet = k.getCategories();
        this.name = lang.equalsIgnoreCase("pt") ? k.getNamePt() : k.getNameEn();
    }

    public String getCategories(){
        StringBuilder listOnString = new StringBuilder();
        for(int i = 0;i < categorySet.size(); i++){
            if (i == categorySet.size() - 1)
                listOnString.append(categorySet.get(i).getSkill());
            else
                listOnString.append(categorySet.get(i).getSkill()).append(", ");
        }
        return listOnString.toString();
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        String urlLink = url != null && !url.trim().isEmpty() ? 
            "<a href=\"" + url + "\" target=\"_blank\">" + url + "</a>" : 
            "N/A";
            
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Conhecimento =================================\\n" +
                    "ID          : " + id      + "\\n" +
                    "Nome        : " + name    + "\\n" +
                    "Nível       : " + level   + "\\n" +
                    "URL         : " + urlLink + "\\n" +
                    "Categorias  : " + getCategories() + "\\n" +
                    "==================================================";
        } else {
            return "=== Knowledge =====================================\\n" +
                    "ID          : " + id      + "\\n" +
                    "Name        : " + name    + "\\n" +
                    "Level       : " + level   + "\\n" +
                    "URL         : " + urlLink + "\\n" +
                    "Categories  : " + getCategories() + "\\n" +
                    "==================================================";
        }
    }
} 