package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.Project;
import com.luixguxto.br.model.entity.category.Category;

import java.util.List;

public class ProjectLang {

    private Long id;
    private String name;
    private String description;
    private String url;
    private final List<Category> categorySet;
    private String lang;

    public ProjectLang(Project p, String lang){
        this.lang = lang;
        this.id = p.getId();
        this.url = p.getUrl();
        this.categorySet = p.getCategories();
        this.name = lang.equalsIgnoreCase("pt") ? p.getNamePt() : p.getNameEn();
        String desc = lang.equalsIgnoreCase("pt") ? p.getDescriptionPt() : p.getDescriptionEn();
        if (desc != null) desc = desc.replaceAll("(\\r\\n|\\n|\\r)", "\\\\n");
        this.description = desc;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
            return "=== Projeto =======================================\\n" +
                    "ID          : " + id          + "\\n" +
                    "Nome        : " + name        + "\\n" +
                    "Descrição   : " + description + "\\n" +
                    "URL         : " + urlLink     + "\\n" +
                    "Categorias  : " + getCategories() + "\\n" +
                    "==================================================";
        } else {
            return "=== Project =======================================\\n" +
                    "ID          : " + id          + "\\n" +
                    "Name        : " + name        + "\\n" +
                    "Description : " + description + "\\n" +
                    "URL         : " + urlLink     + "\\n" +
                    "Categories  : " + getCategories() + "\\n" +
                    "==================================================";
        }
    }
}
