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
        for(int i = 0; i < academicList.size(); i++){
            AcademicLang al = new AcademicLang(academicList.get(i), lang);
            if(i == academicList.size() - 1)
                listOnString.append("[").append(al.getId()).append("] - ").append(al.getCourse());
            else
                listOnString.append("[").append(al.getId()).append("] - ").append(al.getCourse()).append("\\n");
        }
        return listOnString.toString();
    }
}
