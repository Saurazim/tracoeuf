package com.blanchard.ovobio.tracoeuf.controller.vue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Main Controller, pour le moment just une page test
 * TODO faire une page d'accueil et de redirection
 */
@Controller
public class MainController {
    @SuppressWarnings("SameReturnValue")
    @GetMapping(value = {"/", "/index"})
    public String index(Model model, @RequestParam(required = false) String id) {
        String message = "Hello World!";
        String essai = "test";
        String messageId = "transmission ID OK : "+id;
        model.addAttribute("message", message);
        model.addAttribute("essai", essai);
        model.addAttribute("id",messageId);

        System.out.println(this.getClass());

        return "index"; //le modèle ici est index
    }



}
