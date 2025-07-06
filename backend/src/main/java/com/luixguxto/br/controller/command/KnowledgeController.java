package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.Knowledge;
import com.luixguxto.br.model.formatter.KnowledgeFormatter;
import com.luixguxto.br.model.lang.KnowledgeLang;
import com.luixguxto.br.model.service.KnowledgeService;

import java.util.Arrays;
import java.util.List;

public class KnowledgeController {

    public static String knowledgeCommand(String[] args, String lang, KnowledgeService service) throws Exception{
        String errorMsgId = lang.equalsIgnoreCase("pt")
                ? "ID Inexistente"
                : "Non-existent ID";
        String errorMsgFormat = lang.equalsIgnoreCase("pt")
                ? "O ID deve ser em formato numérico ex. knowledge 1"
                : "The ID must be in numeric format e.g. knowledge 1";
        String errorMsgCategory = lang.equalsIgnoreCase("pt")
                ? "Categoria inexistente. Execute o comando `categories` para visualizar todas as opções disponíveis."
                : "Invalid category. Type `categories` to view all available options.";
        if(args == null)
            return new KnowledgeFormatter(service.findAll(), lang).toString();
        else if(args.length == 0)
            return new KnowledgeFormatter(service.findAll(), lang).toString();
        else if(args[0].equalsIgnoreCase("-c")) {
            List<String> categories = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
            if(categories.isEmpty())
                throw new IllegalArgumentException(errorMsgCategory);
            return new KnowledgeFormatter(service.findAllByCategory(categories), lang).toString();
        }
        else{
            try {
                Long id = Long.parseLong(args[0]);
                Knowledge knowledge = service.findById(id);
                if(knowledge == null)
                    throw new IllegalStateException(errorMsgId);
                KnowledgeLang kl = new KnowledgeLang(knowledge, lang);
                return kl.toString();
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