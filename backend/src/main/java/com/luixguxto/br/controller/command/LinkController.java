package com.luixguxto.br.controller.command;

import com.luixguxto.br.model.entity.Link;
import com.luixguxto.br.model.entity.Profile;
import com.luixguxto.br.model.lang.ProfileLang;
import com.luixguxto.br.model.service.LinkService;
import com.luixguxto.br.model.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class LinkController {
    
    public static String getCommand(String[] args, String lang, LinkService linkService, ProfileService profileService) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        
        if (args == null || args.length == 0) {
            response.put("type", "help");
            response.put("message", getHelpMessage(lang));
            return mapper.writeValueAsString(response);
        }
        
        String what = args[0].toLowerCase();
        
        switch (what) {
            case "certificates":
                return handleCertificates(lang, linkService, mapper);
            case "cv":
                return handleCV(lang, profileService, mapper);
            default:
                return handleCustomLink(what, lang, linkService, mapper);
        }
    }
    
    private static String handleCertificates(String lang, LinkService linkService, ObjectMapper mapper) throws Exception {
        ObjectNode response = mapper.createObjectNode();
        response.put("type", "redirect");
        response.put("command", "certificates");
        
        // Buscar link de certificados na tabela
        var certificatesLink = linkService.findByName("certificates");
        
        if (certificatesLink.isPresent()) {
            String url = certificatesLink.get().getUrl();
            String message = lang.equals("pt") 
                ? "📚 Redirecionando para meus certificados...\n💡 Se não abrir automaticamente, <a href='" + url + "' target='_blank' class='cli-link'>clique aqui</a>"
                : "📚 Redirecting to my certificates...\n💡 If it doesn't open automatically, <a href='" + url + "' target='_blank' class='cli-link'>click here</a>";
            
            response.put("message", message);
            response.put("url", url);
        } else {
            String message = lang.equals("pt") 
                ? "❌ Link de certificados não encontrado no banco de dados."
                : "❌ Certificates link not found in database.";
            response.put("message", message);
            response.put("url", "");
        }
        
        return mapper.writeValueAsString(response);
    }
    
    private static String handleCV(String lang, ProfileService profileService, ObjectMapper mapper) throws Exception {
        ObjectNode response = mapper.createObjectNode();
        response.put("type", "redirect");
        response.put("command", "cv");
        
        Profile profile = profileService.getProfile();
        ProfileLang pl = new ProfileLang(profile, lang);
        String cvUrl = pl.getUrlCv();
        
        String message = lang.equals("pt") 
            ? "📄 Redirecionando para meu currículo em Português...\n💡 Se não abrir automaticamente, <a href='" + cvUrl + "' target='_blank' class='cli-link'>clique aqui</a>"
            : "📄 Redirecting to my resume in English...\n💡 If it doesn't open automatically, <a href='" + cvUrl + "' target='_blank' class='cli-link'>click here</a>";
        
        response.put("message", message);
        response.put("url", cvUrl);
        
        return mapper.writeValueAsString(response);
    }
    
    private static String handleCustomLink(String linkName, String lang, LinkService linkService, ObjectMapper mapper) throws Exception {
        ObjectNode response = mapper.createObjectNode();
        response.put("type", "redirect");
        response.put("command", linkName);
        
        var link = linkService.findByName(linkName);
        
        if (link.isPresent()) {
            String url = link.get().getUrl();
            String message = lang.equals("pt") 
                ? "🔗 Redirecionando para: " + linkName + "\n💡 Se não abrir automaticamente, <a href='" + url + "' target='_blank' class='cli-link'>clique aqui</a>"
                : "🔗 Redirecting to: " + linkName + "\n💡 If it doesn't open automatically, <a href='" + url + "' target='_blank' class='cli-link'>click here</a>";
            
            response.put("message", message);
            response.put("url", url);
        } else {
            String message = lang.equals("pt") 
                ? "❌ Link '" + linkName + "' não encontrado no banco de dados."
                : "❌ Link '" + linkName + "' not found in database.";
            response.put("message", message);
            response.put("url", "");
        }
        
        return mapper.writeValueAsString(response);
    }
    
    private static String getHelpMessage(String lang) {
        String header = lang.equals("pt") ? "=== Comando Get ========================" : "=== Get Command =======================";
        String footer = "=".repeat(header.length());
        
        StringBuilder output = new StringBuilder();
        output.append(header).append("\n\n");
        
        if (lang.equals("pt")) {
            output.append("💡 Como usar: get [o que pegar]\n\n");
            output.append("📋 Opções disponíveis:\n");
            output.append("   • certificates - Abre Google Drive com certificados\n");
            output.append("   • cv           - Abre currículo (PT/EN baseado no idioma atual)\n");
            output.append("   • [nome]       - Busca link personalizado no banco de dados\n\n");
            output.append("🔧 Exemplos:\n");
            output.append("   • get certificates\n");
            output.append("   • get cv\n");
            output.append("   • get linkedin\n\n");
            output.append("💭 Dica: O comando exibe informações no terminal e redireciona automaticamente para o link.\n");
        } else {
            output.append("💡 How to use: get [what to get]\n\n");
            output.append("📋 Available options:\n");
            output.append("   • certificates - Opens Google Drive with certificates\n");
            output.append("   • cv           - Opens resume (PT/EN based on current language)\n");
            output.append("   • [name]       - Searches for custom link in database\n\n");
            output.append("🔧 Examples:\n");
            output.append("   • get certificates\n");
            output.append("   • get cv\n");
            output.append("   • get linkedin\n\n");
            output.append("💭 Tip: The command displays information in terminal and automatically redirects to the link.\n");
        }
        
        output.append(footer).append("\n");
        return output.toString();
    }
} 