package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.Language;
import com.luixguxto.br.model.formatter.LanguageFormatter;
import com.luixguxto.br.model.lang.LanguageLang;
import com.luixguxto.br.model.service.LanguageService;

public class LanguageController {

    public static String languageCommand(String[] args, String lang, LanguageService service) throws Exception{
        String errorMsgId = lang.equals("pt") ? "ID Inexistente" : "Non-existent ID";
        String errorMsgFormat = lang.equals("pt") ? "O ID deve ser em formato numérico ex. academic 1" : "The ID must be in numeric format e.g. academic 1";
        if(args == null)
            return new LanguageFormatter(service.findAll(), lang).toString();
        else if(args.length == 0)
            return new LanguageFormatter(service.findAll(), lang).toString();
        else{
            try{
                Long id = Long.parseLong(args[0]);
                Language language = service.findById(id);
                if(language == null)
                    throw new IllegalStateException(errorMsgId);
                LanguageLang ll = new LanguageLang(language, lang);
                return ll.toString();
            }catch (IllegalStateException e){
                throw new IllegalStateException(errorMsgId);
            }catch (Exception e){
                throw new Exception(errorMsgFormat);
            }
        }
    }
}
