package com.blanchard.ovobio.tracoeuf.controller.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductionController {
    @GetMapping("/production")
    public String production(){
        return "3_production";
    }

    @GetMapping("/pasto")
    public String pasto(){
        return "4_pasto";
    }
}
