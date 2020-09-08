package com.blanchard.ovobio.tracoeuf.controller.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("SameReturnValue")
@Controller
public class CassageController {
    @GetMapping("/cassage")
    public String cassage(){
        return "2_cassage";
    }

}
