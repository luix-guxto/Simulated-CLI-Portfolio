package com.luixguxto.br.controller;

import com.luixguxto.br.controller.entity.AcademicController;
import com.luixguxto.br.model.lang.ProfileLang;
import com.luixguxto.br.model.service.AcademicService;
import com.luixguxto.br.model.service.ProfileService;
import com.luixguxto.br.util.Response;
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

    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }

    @PostMapping("/cli")
    public String executeCommand(@Valid @RequestBody CommandRequest request){
        try {
            return switch (request.getCmd()) {
                case "profile" ->
                        Response.getResponse(new ProfileLang(profileService.getProfile(), request.getLang()).toString(), 200);
                case "language-levels" -> Response.getResponse("teste", 200);
                case "academic" -> Response.getResponse(AcademicController.academicCommand(request.getArgs(), request.getLang(), academicService), 200);
                default -> Response.getResponse("Unknown command: " + request.getCmd(), 404);
            };
        }catch (Exception e){
            String message = request.getLang().equals("pt") ? "[Erro] - "+e.getMessage() : "[Error] - "+e.getMessage();
            return Response.getResponse(message, 404);
        }
    }

}
