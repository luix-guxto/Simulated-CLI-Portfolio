package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.category.Category;

import java.util.List;

public class CategoryFormatter {

    private final List<Category> categoryList;
    private final String lang;

    public CategoryFormatter(List<Category> categoryList, String lang){
        this.categoryList = categoryList;
        this.lang = lang;
    }

    @Override
    public String toString(){
        if (categoryList.isEmpty()) {
            return lang.equalsIgnoreCase("pt") ? 
                "Nenhuma categoria encontrada." : 
                "No categories found.";
        }

        StringBuilder listOnString = new StringBuilder();
        
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Categorias Disponíveis ===================\\n");
            listOnString.append("💡 Use estas categorias para filtrar outros comandos:\\n");
            listOnString.append("   • project -c [categoria]     (filtrar projetos)\\n");
            listOnString.append("   • certificate -c [categoria] (filtrar certificados)\\n");
            listOnString.append("   • knowledge -c [categoria]   (filtrar conhecimentos)\\n");
            listOnString.append("   • workexperience -c [categoria] (filtrar experiências)\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Available Categories ===================\\n");
            listOnString.append("💡 Use these categories to filter other commands:\\n");
            listOnString.append("   • project -c [category]     (filter projects)\\n");
            listOnString.append("   • certificate -c [category] (filter certificates)\\n");
            listOnString.append("   • knowledge -c [category]   (filter knowledge)\\n");
            listOnString.append("   • workexperience -c [category] (filter work experience)\\n");
            listOnString.append("\\n");
        }
        
        for (int i = 0; i < categoryList.size(); i++) {
            String category = categoryList.get(i).getSkill();
            if(i == categoryList.size() - 1) {
                listOnString.append("• ").append(category);
            } else {
                listOnString.append("• ").append(category).append("\\n");
            }
        }
        
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
} 