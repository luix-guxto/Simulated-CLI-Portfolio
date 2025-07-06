package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.Certificate;
import com.luixguxto.br.model.formatter.CertificateFormatter;
import com.luixguxto.br.model.lang.CertificateLang;
import com.luixguxto.br.model.service.CertificateService;

import java.util.Arrays;
import java.util.List;

public class CertificateController {

    public static String certificateCommand(String[] args, String lang, CertificateService service) throws Exception{
        String errorMsgId = lang.equalsIgnoreCase("pt")
                ? "ID Inexistente"
                : "Non-existent ID";
        String errorMsgFormat = lang.equalsIgnoreCase("pt")
                ? "O ID deve ser em formato numérico ex. certificate 1"
                : "The ID must be in numeric format e.g. certificate 1";
        String errorMsgCategory = lang.equalsIgnoreCase("pt")
                ? "Categoria inexistente. Execute o comando `categories` para visualizar todas as opções disponíveis."
                : "Invalid category. Type `categories` to view all available options.";
        if(args == null)
            return new CertificateFormatter(service.findAll(), lang).toString();
        else if(args.length == 0)
            return new CertificateFormatter(service.findAll(), lang).toString();
        else if(args[0].equalsIgnoreCase("-c")) {
            List<String> categories = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
            if(categories.isEmpty())
                throw new IllegalArgumentException(errorMsgCategory);
            return new CertificateFormatter(service.findAllByCategory(categories), lang).toString();
        }
        else{
            try {
                Long id = Long.parseLong(args[0]);
                Certificate certificate = service.findById(id);
                if(certificate == null)
                    throw new IllegalStateException(errorMsgId);
                CertificateLang cl = new CertificateLang(certificate, lang);
                return cl.toString();
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