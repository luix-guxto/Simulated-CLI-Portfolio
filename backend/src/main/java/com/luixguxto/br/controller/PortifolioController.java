package com.luixguxto.br.controller;

import com.luixguxto.br.model.lang.ProfileLang;
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
public class PortifolioController {

    @Autowired
    private ProfileService profileService;

    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }

    @PostMapping("/cli")
    public String executeCommand(@Valid @RequestBody CommandRequest request){
        return switch (request.getCmd()) {
            case "profile" -> Response.getResponse(new ProfileLang(profileService.getProfile(), request.getLang()).toString(), 200);
            case "language-levels" -> Response.getResponse("teste", 200);
            default -> Response.getResponse("Unknown command: " + request.getCmd(), 404);
        };
    }

}
