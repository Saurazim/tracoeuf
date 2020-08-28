package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.coordinateur.PaletteMetier;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import com.blanchard.ovobio.tracoeuf.service.PaletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PalettesController {
    @Autowired
    PaletteMetier pm;

    private static final String URL_PALETTES = "palettes";
    private static final String URL_SAVE_PALETTES = "save_palettes";
    private static final String JSP_PALETTES = "1a_palettes";
    public static final String ATT_FORM = "form";

    @PostMapping(URL_PALETTES)
    public String palettes(@ModelAttribute LivraisonBo bo){
        return JSP_PALETTES;
    }

    @PostMapping(URL_SAVE_PALETTES)
    public String palettesDtos(@ModelAttribute LivraisonForm form){
        pm.savePalettes(form);
        if (pm.getErreurs().isEmpty()){
            Model model = new ConcurrentModel();
            model.addAttribute("resultat", pm.getResultat());
            return "redirect:/livraison";
        }
        Model model = new ConcurrentModel();
        model.addAttribute(ATT_FORM, pm);
        return JSP_PALETTES;
    }
}
