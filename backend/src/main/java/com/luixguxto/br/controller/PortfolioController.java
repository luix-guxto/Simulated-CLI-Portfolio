package com.luixguxto.br.controller;

import com.luixguxto.br.controller.command.*;
import com.luixguxto.br.controller.command.parameter.CommandParameter;
import com.luixguxto.br.model.entity.category.Category;
import com.luixguxto.br.model.formatter.CategoryFormatter;
import com.luixguxto.br.model.lang.ProfileLang;
import com.luixguxto.br.model.service.*;
import com.luixguxto.br.controller.command.LinkController;
import com.luixguxto.br.util.Response;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Tag(name = "Cli PortiFolio", description = "Run Commands with API REST")
@RestController
@RequestMapping("/")
public class PortfolioController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AcademicService academicService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private WorkExperienceService workExperienceService;

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LinkService linkService;

    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }

    private String getHelp(String lang) {
        if (lang.equalsIgnoreCase("pt")) {
            return "=== Comandos Disponíveis =====================\\n" +
                    "profile                    - Mostra informações do perfil\\n" +
                    "fluency                    - Lista todos os idiomas\\n" +
                    "fluency [ID]               - Mostra detalhes do idioma\\n" +
                    "academic                   - Lista formação acadêmica\\n" +
                    "academic [ID]              - Mostra detalhes da formação\\n" +
                    "project                    - Lista todos os projetos\\n" +
                    "project [ID]               - Mostra detalhes do projeto\\n" +
                    "project -c [categoria]     - Filtra projetos por categoria\\n" +
                    "certificate                - Lista todos os certificados\\n" +
                    "certificate [ID]           - Mostra detalhes do certificado\\n" +
                    "certificate -c [categoria] - Filtra certificados por categoria\\n" +
                    "work                       - Lista experiências de trabalho\\n" +
                    "work [ID]                  - Mostra detalhes da experiência\\n" +
                    "work -c [categoria]        - Filtra experiências por categoria\\n" +
                    "knowledge                  - Lista todos os conhecimentos\\n" +
                    "knowledge [ID]             - Mostra detalhes do conhecimento\\n" +
                    "knowledge -c [categoria]   - Filtra conhecimentos por categoria\\n" +
                    "categories                 - Lista todas as categorias\\n" +
                    "get [o que pegar]          - Acessa links (certificates, cv, etc.)\\n" +
                    "help                       - Mostra esta ajuda\\n" +
                    "==================================================";
        } else {
            return "=== Available Commands =======================\\n" +
                    "profile                    - Shows profile information\\n" +
                    "fluency                    - Lists all languages\\n" +
                    "fluency [ID]               - Shows language details\\n" +
                    "academic                   - Lists academic background\\n" +
                    "academic [ID]              - Shows academic details\\n" +
                    "project                    - Lists all projects\\n" +
                    "project [ID]               - Shows project details\\n" +
                    "project -c [category]      - Filters projects by category\\n" +
                    "certificate                - Lists all certificates\\n" +
                    "certificate [ID]           - Shows certificate details\\n" +
                    "certificate -c [category]  - Filters certificates by category\\n" +
                    "work                       - Lists work experiences\\n" +
                    "work [ID]                  - Shows work experience details\\n" +
                    "work -c [category]         - Filters work experiences by category\\n" +
                    "knowledge                  - Lists all knowledge\\n" +
                    "knowledge [ID]             - Shows knowledge details\\n" +
                    "knowledge -c [category]    - Filters knowledge by category\\n" +
                    "categories                 - Lists all categories\\n" +
                    "get [what to get]          - Access links (certificates, cv, etc.)\\n" +
                    "help                       - Shows this help\\n" +
                    "==================================================";
        }
    }

    @GetMapping("/categories")
    public String getCategories() {
        try {
            List<Category> categories = categoryService.findAll();
            StringBuilder categoriesString = new StringBuilder();
            categoriesString.append("[");
            for (int i = 0; i < categories.size(); i++) {
                if(i == categories.size() - 1)
                    categoriesString.append("\"").append(categories.get(i).getSkill()).append("\"");
                else
                    categoriesString.append("\"").append(categories.get(i).getSkill()).append("\", ");
            }
            categoriesString.append("]");
            return Response.getResponseData(categoriesString.toString(), 200);

        } catch (Exception e) {
            return Response.getResponse("Error fetching categories", 505);
        }
    }

    @PostMapping("/cli")
    public String executeCommand(@Valid @RequestBody CommandParameter request){
        try {
            return switch (request.getCmd()) {
                case "profile" ->
                        Response.getResponse(
                                new ProfileLang(profileService.getProfile(), request.getLang()).toString(),
                                200);
                case "fluency" ->
                        Response.getResponse(
                                LanguageController.languageCommand(request.getArgs(), request.getLang(), languageService),
                                200);
                case "academic" ->
                        Response.getResponse(
                                AcademicController.academicCommand(request.getArgs(), request.getLang(), academicService),
                                200);
                case "project" ->
                        Response.getResponse(
                                ProjectController.projectCommand(request.getArgs(), request.getLang(), projectService),
                                200);
                case "certificate" ->
                        Response.getResponse(
                                CertificateController.certificateCommand(request.getArgs(), request.getLang(), certificateService),
                                200);
                case "work" ->
                        Response.getResponse(
                                WorkExperienceController.workExperienceCommand(request.getArgs(), request.getLang(), workExperienceService),
                                200);
                case "knowledge" ->
                        Response.getResponse(
                                KnowledgeController.knowledgeCommand(request.getArgs(), request.getLang(), knowledgeService),
                                200);
                case "categories" ->
                        Response.getResponse(
                                new CategoryFormatter(categoryService.findAll(), request.getLang()).toString(),
                                200);
                case "get" ->
                        Response.getResponseData(
                                LinkController.getCommand(request.getArgs(), request.getLang(), linkService, profileService),
                                200);
 
                case "help" ->
                        Response.getResponse(
                                getHelp(request.getLang()),
                                200);
                default ->
                        Response.getResponse(
                                "Unknown command: " + request.getCmd(),
                                404);
            };
        }catch (Exception e){
            String message = request.getLang().equals("pt") ? "[Erro] - "+e.getMessage() : "[Error] - "+e.getMessage();
            return Response.getResponse(message, 404);
        }
    }

}
