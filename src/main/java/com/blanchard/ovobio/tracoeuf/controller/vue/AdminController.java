package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.coordinateur.AdminLivMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    AdminLivMetier alm;

    @GetMapping("/admin")
    public String getViewAdmin(Model model){
        model.addAttribute("livraisons", alm.getListLivraisons());
        model.addAttribute("palettes", alm.getListPalettes());
        return "admin";
    }

}
