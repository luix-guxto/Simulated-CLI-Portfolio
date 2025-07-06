package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.WorkExperience;
import com.luixguxto.br.model.formatter.WorkExperienceFormatter;
import com.luixguxto.br.model.lang.WorkExperienceLang;
import com.luixguxto.br.model.service.WorkExperienceService;

import java.util.Arrays;
import java.util.List;

public class WorkExperienceController {

    public static String workExperienceCommand(String[] args, String lang, WorkExperienceService service) throws Exception{
        String errorMsgId = lang.equalsIgnoreCase("pt")
                ? "ID Inexistente"
                : "Non-existent ID";
        String errorMsgFormat = lang.equalsIgnoreCase("pt")
                ? "O ID deve ser em formato numérico ex. work 1"
                : "The ID must be in numeric format e.g. work 1";
        String errorMsgCategory = lang.equalsIgnoreCase("pt")
                ? "Categoria inexistente. Execute o comando `categories` para visualizar todas as opções disponíveis."
                : "Invalid category. Type `categories` to view all available options.";
        if(args == null)
            return new WorkExperienceFormatter(service.findAll(), lang).toString();
        else if(args.length == 0)
            return new WorkExperienceFormatter(service.findAll(), lang).toString();
        else if(args[0].equalsIgnoreCase("-c")) {
            List<String> categories = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
            if(categories.isEmpty())
                throw new IllegalArgumentException(errorMsgCategory);
            return new WorkExperienceFormatter(service.findAllByCategory(categories), lang).toString();
        }
        else{
            try {
                Long id = Long.parseLong(args[0]);
                WorkExperience workExperience = service.findById(id);
                if(workExperience == null)
                    throw new IllegalStateException(errorMsgId);
                WorkExperienceLang wel = new WorkExperienceLang(workExperience, lang);
                return wel.toString();
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