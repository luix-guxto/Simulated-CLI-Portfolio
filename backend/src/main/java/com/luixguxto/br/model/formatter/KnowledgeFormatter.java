package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.Knowledge;
import com.luixguxto.br.model.lang.KnowledgeLang;

import java.util.List;

public class KnowledgeFormatter {

    private final List<Knowledge> knowledgeList;
    private final String lang;

    public KnowledgeFormatter(List<Knowledge> knowledgeList, String lang){
        this.knowledgeList = knowledgeList;
        this.lang = lang;
    }

    @Override
    public String toString(){
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Conhecimentos Disponíveis ===================\\n");
            listOnString.append("💡 Para ver detalhes de um conhecimento específico, digite: knowledge [id]\\n");
            listOnString.append("💡 Para filtrar por categoria, digite: knowledge -c [categoria]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Available Knowledge ===================\\n");
            listOnString.append("💡 To see details of a specific knowledge, type: knowledge [id]\\n");
            listOnString.append("💡 To filter by category, type: knowledge -c [category]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de conhecimentos com IDs clicáveis
        for (int i = 0; i < knowledgeList.size(); i++) {
            KnowledgeLang know = new KnowledgeLang(knowledgeList.get(i), lang);
            if(i == knowledgeList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"knowledge ")
                        .append(know.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(know.getId())
                        .append("]</a> - ")
                        .append(know.getName())
                        .append(" - [")
                        .append(know.getCategories())
                        .append("]");
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"knowledge ")
                        .append(know.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(know.getId())
                        .append("]</a> - ")
                        .append(know.getName())
                        .append(" - [")
                        .append(know.getCategories())
                        .append("]")
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
} 