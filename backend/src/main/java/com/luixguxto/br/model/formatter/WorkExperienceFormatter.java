package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.WorkExperience;
import com.luixguxto.br.model.lang.WorkExperienceLang;

import java.util.List;

public class WorkExperienceFormatter {

    private final List<WorkExperience> workExperienceList;
    private final String lang;

    public WorkExperienceFormatter(List<WorkExperience> workExperienceList, String lang){
        this.workExperienceList = workExperienceList;
        this.lang = lang;
    }

    @Override
    public String toString(){
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Experiências Profissionais ===================\\n");
            listOnString.append("💡 Para ver detalhes de uma experiência específica, digite: work [id]\\n");
            listOnString.append("💡 Para filtrar por categoria, digite: work -c [categoria]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Work Experience ===================\\n");
            listOnString.append("💡 To see details of a specific work experience, type: work [id]\\n");
            listOnString.append("💡 To filter by category, type: work -c [category]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de experiências profissionais com IDs clicáveis
        for (int i = 0; i < workExperienceList.size(); i++) {
            WorkExperienceLang work = new WorkExperienceLang(workExperienceList.get(i), lang);
            if(i == workExperienceList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"work ")
                        .append(work.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(work.getId())
                        .append("]</a> - ")
                        .append(work.getRole())
                        .append(" - [")
                        .append(work.getCategories())
                        .append("]");
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"work ")
                        .append(work.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(work.getId())
                        .append("]</a> - ")
                        .append(work.getRole())
                        .append(" - [")
                        .append(work.getCategories())
                        .append("]")
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
} 