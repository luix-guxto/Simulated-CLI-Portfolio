package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.Academic;
import com.luixguxto.br.model.lang.AcademicLang;

import java.util.List;

public class AcademicFormatter {

    private final List<Academic> academicList;
    private final String lang;

    public AcademicFormatter(List<Academic> academicList, String lang) {
        this.academicList = academicList;
        this.lang = lang;
    }

    @Override
    public String toString() {
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Formação Acadêmica ===================\\n");
            listOnString.append("💡 Para ver detalhes de uma formação específica, digite: academic [id]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Academic Background ===================\\n");
            listOnString.append("💡 To see details of a specific academic record, type: academic [id]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de formações acadêmicas com IDs clicáveis
        for(int i = 0; i < academicList.size(); i++){
            AcademicLang al = new AcademicLang(academicList.get(i), lang);
            if(i == academicList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"academic ")
                        .append(al.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(al.getId())
                        .append("]</a> - ")
                        .append(al.getCourse());
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"academic ")
                        .append(al.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(al.getId())
                        .append("]</a> - ")
                        .append(al.getCourse())
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
}
