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
        for(int i = 0; i < languageList.size(); i++){
            LanguageLang ll = new LanguageLang(languageList.get(i), lang);
            if(i == languageList.size() - 1)
                listOnString.append("[").append(ll.getId()).append("] - ").append(ll.getName());
            else
                listOnString.append("[").append(ll.getId()).append("] - ").append(ll.getName()).append("\\n");
        }
        return listOnString.toString();
    }
}
