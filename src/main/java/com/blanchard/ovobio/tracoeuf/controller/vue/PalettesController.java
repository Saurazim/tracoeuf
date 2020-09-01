package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.coordinateur.PaletteMetier;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
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

    private static final String ATT_RESULTAT = "resultat";
    private static final String ATT_ERREURS = "erreurs";

    @PostMapping(ConstInt.PALETTES_URL)
    public String palettes(@ModelAttribute LivraisonBo bo){
        return ConstInt.PALETTES_JSP;
    }

    @PostMapping(ConstInt.PALETTES_URL_SAVE)
    public String palettesDtos(@ModelAttribute LivraisonForm form){
        pm.savePalettes(form);
        Model model = new ConcurrentModel();
        model.addAttribute(ATT_RESULTAT, pm.getResultat());
        if (pm.getErreurs().isEmpty()){
            return ConstInt.REDIRECT+ConstInt.LIVRAISON_URL;
        }
        model.addAttribute(ConstInt.ATT_FORM, pm);
        model.addAttribute(ATT_ERREURS,pm.getErreurs());
        return ConstInt.PALETTES_JSP;
    }
}
