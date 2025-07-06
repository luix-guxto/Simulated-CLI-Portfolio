package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.Language;
import com.luixguxto.br.model.lang.LanguageLang;

import java.util.List;

public class LanguageFormatter {

    private final List<Language> languageList;
    private final String lang;

    public LanguageFormatter(List<Language> languageList, String lang){
        this.languageList = languageList;
        this.lang = lang;
    }
    @Override
    public String toString() {
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Idiomas Disponíveis ===================\\n");
            listOnString.append("💡 Para ver detalhes de um idioma específico, digite: fluency [id]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Available Languages ===================\\n");
            listOnString.append("💡 To see details of a specific language, type: fluency [id]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de idiomas com IDs clicáveis
        for(int i = 0; i < languageList.size(); i++){
            LanguageLang ll = new LanguageLang(languageList.get(i), lang);
            if(i == languageList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"fluency ")
                        .append(ll.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(ll.getId())
                        .append("]</a> - ")
                        .append(ll.getName());
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"fluency ")
                        .append(ll.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(ll.getId())
                        .append("]</a> - ")
                        .append(ll.getName())
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
}
