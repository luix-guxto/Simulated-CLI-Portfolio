package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.WorkExperience;
import com.luixguxto.br.model.entity.category.Category;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class WorkExperienceLang {

    private Long id;
    private String company;
    private String companyUrl;
    private String startDate;
    private String endDate;
    private String role;
    private String location;
    private String isCurrent;
    private String description;
    private final List<Category> categorySet;
    private String lang;

    public WorkExperienceLang(WorkExperience w, String lang){
        this.lang = lang;
        this.id = w.getId();
        this.company = w.getCompany();
        this.companyUrl = w.getCompanyUrl();
        this.location = w.getLocation();
        this.categorySet = w.getCategories();
        this.role = lang.equalsIgnoreCase("pt") ? w.getRolePt() : w.getRoleEn();
        String desc = lang.equalsIgnoreCase("pt") ? w.getDescriptionPt() : w.getDescriptionEn();
        if (desc != null) desc = desc.replaceAll("(\\r\\n|\\n|\\r)", "\\\\n");
        this.description = desc;
        this.isCurrent = w.getIsCurrent() != null && w.getIsCurrent() ? 
            (lang.equalsIgnoreCase("pt") ? "Sim" : "Yes") : 
            (lang.equalsIgnoreCase("pt") ? "Não" : "No");
        
        DateTimeFormatter formatter = lang.equalsIgnoreCase("pt") ? 
            DateTimeFormatter.ofPattern("dd/MM/yyyy") : 
            DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.startDate = w.getStartDate() != null ? w.getStartDate().format(formatter) : "";
        this.endDate = w.getEndDate() != null ? w.getEndDate().format(formatter) : "";
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(String isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        String companyUrlLink = companyUrl != null && !companyUrl.trim().isEmpty() ? 
            "<a href=\"" + companyUrl + "\" target=\"_blank\">" + companyUrl + "</a>" : 
            "N/A";
            
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Experiência de Trabalho =====================\\n" +
                    "ID          : " + id          + "\\n" +
                    "Empresa     : " + company     + "\\n" +
                    "URL Empresa : " + companyUrlLink + "\\n" +
                    "Cargo       : " + role        + "\\n" +
                    "Localização : " + location    + "\\n" +
                    "Data Início : " + startDate   + "\\n" +
                    "Data Fim    : " + endDate     + "\\n" +
                    "Atual       : " + isCurrent   + "\\n" +
                    "Descrição   : " + description + "\\n" +
                    "Categorias  : " + getCategories() + "\\n" +
                    "==================================================";
        } else {
            return "=== Work Experience =============================\\n" +
                    "ID          : " + id          + "\\n" +
                    "Company     : " + company     + "\\n" +
                    "Company URL : " + companyUrlLink + "\\n" +
                    "Role        : " + role        + "\\n" +
                    "Location    : " + location    + "\\n" +
                    "Start Date  : " + startDate   + "\\n" +
                    "End Date    : " + endDate     + "\\n" +
                    "Current     : " + isCurrent   + "\\n" +
                    "Description : " + description + "\\n" +
                    "Categories  : " + getCategories() + "\\n" +
                    "==================================================";
        }
    }
} 