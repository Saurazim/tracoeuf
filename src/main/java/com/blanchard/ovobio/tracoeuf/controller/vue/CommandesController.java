package com.blanchard.ovobio.tracoeuf.controller.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandesController {
    @GetMapping("/commandes")
    public String commandes(){
        return "5_commandes";
    }
}
