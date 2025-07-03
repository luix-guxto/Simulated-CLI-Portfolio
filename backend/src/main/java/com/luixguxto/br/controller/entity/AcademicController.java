package com.luixguxto.br.controller.entity;

import com.luixguxto.br.model.entity.Academic;
import com.luixguxto.br.model.formatter.AcademicFormatter;
import com.luixguxto.br.model.lang.AcademicLang;
import com.luixguxto.br.model.service.AcademicService;

public class AcademicController {

    public static String academicCommand(String[] args, String lang, AcademicService service) throws Exception {
        String errorMsgId = lang.equals("pt") ? "ID Inexistente" : "Non-existent ID";
        String errorMsgFormat = lang.equals("pt") ? "O ID deve ser em formato numérico ex. academic 1" : "The ID must be in numeric format e.g. academic 1";
        if(args == null)
            return new AcademicFormatter(service.findAll(), lang).toString();
        else if (args.length == 0)
            return new AcademicFormatter(service.findAll(), lang).toString();
        else{
            try {
                Long id = Long.parseLong(args[0]);
                Academic academic = service.findById(id);
                if(academic == null)
                    throw new IllegalStateException(errorMsgId);
                AcademicLang al = new AcademicLang(academic,lang);
                return al.toString();
            }catch (IllegalStateException e){
                throw new IllegalStateException(errorMsgId);
            }
            catch (Exception e){
                throw new Exception(errorMsgFormat);
            }
        }
    }
}
