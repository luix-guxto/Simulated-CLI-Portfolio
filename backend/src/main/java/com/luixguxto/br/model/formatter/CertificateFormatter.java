package com.luixguxto.br.model.formatter;

import com.luixguxto.br.model.entity.Certificate;
import com.luixguxto.br.model.lang.CertificateLang;

import java.util.List;

public class CertificateFormatter {

    private final List<Certificate> certificateList;
    private final String lang;

    public CertificateFormatter(List<Certificate> certificateList, String lang){
        this.certificateList = certificateList;
        this.lang = lang;
    }

    @Override
    public String toString(){
        StringBuilder listOnString = new StringBuilder();
        
        // Cabeçalho padrão
        if (lang.equalsIgnoreCase("pt")) {
            listOnString.append("=== Certificados Disponíveis ===================\\n");
            listOnString.append("💡 Para ver detalhes de um certificado específico, digite: certificate [id]\\n");
            listOnString.append("💡 Para filtrar por categoria, digite: certificate -c [categoria]\\n");
            listOnString.append("💡 <b>Dica:</b> Clique nos IDs para ver detalhes automaticamente!\\n");
            listOnString.append("\\n");
        } else {
            listOnString.append("=== Available Certificates ===================\\n");
            listOnString.append("💡 To see details of a specific certificate, type: certificate [id]\\n");
            listOnString.append("💡 To filter by category, type: certificate -c [category]\\n");
            listOnString.append("💡 <b>Tip:</b> Click on IDs to see details automatically!\\n");
            listOnString.append("\\n");
        }
        
        // Lista de certificados com IDs clicáveis
        for (int i = 0; i < certificateList.size(); i++) {
            CertificateLang cert = new CertificateLang(certificateList.get(i), lang);
            if(i == certificateList.size() - 1)
                listOnString
                        .append("<a href=\"#\" data-command=\"certificate ")
                        .append(cert.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(cert.getId())
                        .append("]</a> - ")
                        .append(cert.getName())
                        .append(" - [")
                        .append(cert.getCategories())
                        .append("]");
            else
                listOnString
                        .append("<a href=\"#\" data-command=\"certificate ")
                        .append(cert.getId())
                        .append("\" class=\"cli-link\">[")
                        .append(cert.getId())
                        .append("]</a> - ")
                        .append(cert.getName())
                        .append(" - [")
                        .append(cert.getCategories())
                        .append("]")
                        .append("\\n");
        }
        
        // Rodapé padrão
        listOnString.append("\\n==================================================");
        
        return listOnString.toString();
    }
} 