package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.Project;
import com.luixguxto.br.model.formatter.ProjectFormatter;
import com.luixguxto.br.model.lang.ProjectLang;
import com.luixguxto.br.model.service.ProjectService;

import java.util.Arrays;
import java.util.List;

public class ProjectController {

    public static String projectCommand(String[] args, String lang, ProjectService service) throws Exception{
        String errorMsgId = lang.equalsIgnoreCase("pt")
                ? "ID Inexistente"
                : "Non-existent ID";
        String errorMsgFormat = lang.equalsIgnoreCase("pt")
                ? "O ID deve ser em formato numérico ex. project 1"
                : "The ID must be in numeric format e.g. project 1";
        String errorMsgCategory = lang.equalsIgnoreCase("pt")
                ? "Categoria inexistente. Execute o comando `categories` para visualizar todas as opções disponíveis."
                : "Invalid category. Type `categories` to view all available options.";
        if(args == null)
            return new ProjectFormatter(service.findAll(), lang).toString();
        else if(args.length == 0)
            return new ProjectFormatter(service.findAll(), lang).toString();
        else if(args[0].equalsIgnoreCase("-c")) {
            List<String> categories = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
            if(categories.isEmpty())
                throw new IllegalArgumentException(errorMsgCategory);
            return new ProjectFormatter(service.findAllByCategory(categories), lang).toString();
        }
        else{
            try {
                Long id = Long.parseLong(args[0]);
                Project project = service.getById(id);
                if(project == null)
                    throw new IllegalStateException(errorMsgId);
                ProjectLang pl = new ProjectLang(project, lang);
                return pl.toString();
            }catch (IllegalStateException e){
                throw new IllegalStateException(errorMsgId);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException(errorMsgCategory);
            }catch (Exception e){
                throw new Exception(errorMsgFormat);
            }
        }
    }
}
