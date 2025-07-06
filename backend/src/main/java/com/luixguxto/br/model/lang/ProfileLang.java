package com.luixguxto.br.model.lang;


import com.luixguxto.br.model.entity.Profile;

public class ProfileLang {

    private String name;
    private String title;
    private String bio;
    private String email;
    private String phone;
    private String location;
    private String linkedin;
    private String github;
    private String urlCv;
    private String lang;


    public ProfileLang(Profile p, String lang) {
        this.name = p.getName();
        this.title = lang.equalsIgnoreCase("pt") ? p.getTitlePt() : p.getTitleEn();
        this.bio = lang.equalsIgnoreCase("pt") ? p.getBioPt() : p.getBioEn();
        this.email = p.getEmail();
        this.phone = p.getPhone();
        this.location = p.getLocation();
        this.linkedin = p.getLinkedin();
        this.github = p.getGithub();
        this.urlCv = lang.equalsIgnoreCase("pt") ? p.getUrlCvPt() : p.getUrlCvEn();
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String linkedinLink = linkedin != null && !linkedin.trim().isEmpty() ? 
            "<a href=\"" + linkedin + "\" target=\"_blank\">" + linkedin + "</a>" : 
            "N/A";
        String githubLink = github != null && !github.trim().isEmpty() ? 
            "<a href=\"" + github + "\" target=\"_blank\">" + github + "</a>" : 
            "N/A";
        String cvLink = urlCv != null && !urlCv.trim().isEmpty() ? 
            "<a href=\"" + urlCv + "\" target=\"_blank\">" + urlCv + "</a>" : 
            "N/A";
        String emailLink = email != null && !email.trim().isEmpty() ? 
            "<a href=\"mailto:" + email + "\">" + email + "</a>" : 
            "N/A";
            
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Perfil ================================\\n" +
                    "Nome     : " + name + "\\n" +
                    "Título   : " + title + "\\n" +
                    "Bio      : \\n  " + bio + "\\n" +
                    "Email    : " + emailLink + "\\n" +
                    "Telefone : " + phone + "\\n" +
                    "Local    : " + location + "\\n" +
                    "LinkedIn : " + linkedinLink + "\\n" +
                    "GitHub   : " + githubLink + "\\n" +
                    "Currículo: " + cvLink + "\\n" +
                    "===========================================";
        } else {
            return "=== Profile ===============================\\n" +
                    "Name     : " + name + "\\n" +
                    "Title    : " + title + "\\n" +
                    "Bio      : \\n  " + bio + "\\n" +
                    "Email    : " + emailLink + "\\n" +
                    "Phone    : " + phone + "\\n" +
                    "Location : " + location + "\\n" +
                    "LinkedIn : " + linkedinLink + "\\n" +
                    "GitHub   : " + githubLink + "\\n" +
                    "CV       : " + cvLink + "\\n" +
                    "===========================================";
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getUrlCv() {
        return urlCv;
    }

    public void setUrlCv(String urlCv) {
        this.urlCv = urlCv;
    }
}
