package com.luixguxto.br.model.lang;

import com.luixguxto.br.model.entity.Academic;
import com.luixguxto.br.util.enums.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AcademicLang {
    private Long id;
    private String course;
    private String organization;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private String lang;

    public AcademicLang(Academic a, String lang){
        this.id = a.getId();
        this.course = lang.equalsIgnoreCase("pt") ? a.getCoursePt() : a.getCourseEn();
        this.organization = a.getOrganization();
        this.startDate = a.getStartDate();
        this.endDate = a.getEndDate();
        this.status = a.getStatus();
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status.getLabel(lang);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = "pt".equalsIgnoreCase(lang) ? 
            DateTimeFormatter.ofPattern("dd/MM/yyyy") : 
            DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        String startDateFormatted = startDate != null ? startDate.format(formatter) : "";
        String endDateFormatted = endDate != null ? endDate.format(formatter) : "";
        
        if ("pt".equalsIgnoreCase(lang)) {
            return "=== Formação Acadêmica ===========================\\n" +
                    "ID         : " + id + "\\n" +
                    "Curso      : " + course + "\\n" +
                    "Instituição: " + organization + "\\n" +
                    "Início     : " + startDateFormatted + "\\n" +
                    "Fim        : " + (endDate == null ? "Em andamento" : endDateFormatted) + "\\n" +
                    "Status     : " + getStatus() + "\\n" +
                    "==================================================";
        } else {
            return "=== Academic Background ==========================\\n" +
                    "ID          : " + id + "\\n" +
                    "Course      : " + course + "\\n" +
                    "Organization: " + organization + "\\n" +
                    "Start Date  : " + startDateFormatted + "\\n" +
                    "End Date    : " + (endDate == null ? "In progress" : endDateFormatted) + "\\n" +
                    "Status      : " + getStatus() + "\\n" +
                    "==================================================";
        }
    }
}
