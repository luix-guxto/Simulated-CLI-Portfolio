package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.Project;
import com.luixguxto.br.model.lang.ProjectLang;

import java.util.List;

public class ProjectFormatter {

    private final List<Project> projectList;
    private final String lang;

    public ProjectFormatter(List<Project> projectList, String lang){
        this.projectList = projectList;
        this.lang = lang;
    }

    @Override
    public String toString(){
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Projetos Disponíveis ===================\\n");
            listOnString.append("💡 Para ver detalhes de um projeto específico, digite: project [id]\\n");
            listOnString.append("💡 Para filtrar por categoria, digite: project -c [categoria]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Available Projects ===================\\n");
            listOnString.append("💡 To see details of a specific project, type: project [id]\\n");
            listOnString.append("💡 To filter by category, type: project -c [category]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de projetos com IDs clicáveis
        for (int i = 0; i < projectList.size(); i++) {
            ProjectLang pj = new ProjectLang(projectList.get(i), lang);
            if(i == projectList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"project ")
                        .append(pj.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(pj.getId())
                        .append("]</a> - ")
                        .append(pj.getName())
                        .append(" - [")
                        .append(pj.getCategories())
                        .append("]");
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"project ")
                        .append(pj.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(pj.getId())
                        .append("]</a> - ")
                        .append(pj.getName())
                        .append(" - [")
                        .append(pj.getCategories())
                        .append("]")
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
}
