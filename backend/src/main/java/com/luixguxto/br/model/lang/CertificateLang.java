package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.Certificate;
import com.luixguxto.br.model.entity.category.Category;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CertificateLang {

    private Long id;
    private String name;
    private String organization;
    private String issueDate;
    private String expirationDate;
    private String description;
    private String code;
    private String url;
    private final List<Category> categorySet;
    private String lang;

    public CertificateLang(Certificate c, String lang) {
        this.lang = lang;
        this.id = c.getId();
        this.organization = c.getOrganization();
        DateTimeFormatter formatter = lang.equalsIgnoreCase("pt") ? 
            DateTimeFormatter.ofPattern("dd/MM/yyyy") : DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.issueDate = c.getIssueDate() != null ? c.getIssueDate().format(formatter) : "";
        this.expirationDate = c.getExpirationDate() != null ? c.getExpirationDate().format(formatter) : "";
        this.code = c.getCode();
        this.url = c.getUrl();
        this.categorySet = c.getCategories();
        this.name = lang.equalsIgnoreCase("pt") ? c.getNamePt() : c.getNameEn();
        String desc = lang.equalsIgnoreCase("pt") ? c.getDescriptionPt() : c.getDescriptionEn();
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
            return "=== Certificado ===================================\\n" +
                    "ID              : " + id              + "\\n" +
                    "Nome            : " + name            + "\\n" +
                    "Organização     : " + organization    + "\\n" +
                    "Data de Emissão : " + issueDate       + "\\n" +
                    "Data de Expiração: " + expirationDate + "\\n" +
                    "Descrição       : " + description     + "\\n" +
                    "Código          : " + code            + "\\n" +
                    "URL             : " + urlLink         + "\\n" +
                    "Categorias      : " + getCategories() + "\\n" +
                    "==================================================";
        } else {
            return "=== Certificate ===================================\\n" +
                    "ID              : " + id              + "\\n" +
                    "Name            : " + name            + "\\n" +
                    "Organization    : " + organization    + "\\n" +
                    "Issue Date      : " + issueDate       + "\\n" +
                    "Expiration Date : " + expirationDate  + "\\n" +
                    "Description     : " + description     + "\\n" +
                    "Code            : " + code            + "\\n" +
                    "URL             : " + urlLink         + "\\n" +
                    "Categories      : " + getCategories() + "\\n" +
                    "==================================================";
        }
    }
} 