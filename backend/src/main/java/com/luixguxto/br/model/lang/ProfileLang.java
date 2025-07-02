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
        this.title = lang.equals("pt") ? p.getTitlePt() : p.getTitleEn();
        this.bio = lang.equals("pt") ? p.getBioPt() : p.getBioEn();
        this.email = p.getEmail();
        this.phone = p.getPhone();
        this.location = p.getLocation();
        this.linkedin = p.getLinkedin();
        this.github = p.getGithub();
        this.urlCv = lang.equals("pt") ? p.getUrlCvPt() : p.getUrlCvEn();
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
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Perfil ================================\\n" +
                    "Nome     : " + name + "\\n" +
                    "Título   : " + title + "\\n" +
                    "Bio      : \\n  " + bio + "\\n" +
                    "Email    : " + email + "\\n" +
                    "Telefone : " + phone + "\\n" +
                    "Local    : " + location + "\\n" +
                    "LinkedIn : " + linkedin + "\\n" +
                    "GitHub   : " + github + "\\n" +
                    "Currículo: " + urlCv + "\\n" +
                    "===========================================\\n";
        } else {
            return "=== Profile ===============================\\n" +
                    "Name     : " + name + "\\n" +
                    "Title    : " + title + "\\n" +
                    "Bio      : \\n  " + bio + "\\n" +
                    "Email    : " + email + "\\n" +
                    "Phone    : " + phone + "\\n" +
                    "Location : " + location + "\\n" +
                    "LinkedIn : " + linkedin + "\\n" +
                    "GitHub   : " + github + "\\n" +
                    "CV       : " + urlCv + "\\n" +
                    "===========================================\\n";
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
