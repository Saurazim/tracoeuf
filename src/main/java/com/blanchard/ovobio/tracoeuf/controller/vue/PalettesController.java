package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.coordinateur.LivraisonMetier;
import com.blanchard.ovobio.tracoeuf.coordinateur.PaletteMetier;
import com.blanchard.ovobio.tracoeuf.dto.LivPalDto;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PalettesController {
    @Autowired
    PaletteMetier pm;

    @Autowired
    LivraisonMetier lm;

    private static final String ATT_RESULTAT = "resultat";
    private static final String ATT_ERREURS = "erreurs";
    private static final String ATT_LIVRAISONS = "livraisons";
    private static final String ATT_DATES = "dates";


    @GetMapping(ConstInt.PALETTES_URL)
    public String palettes(Model model) throws JsonProcessingException {
        model.addAllAttributes(initView());
        return ConstInt.PALETTES_JSP;
    }

    @PostMapping(ConstInt.PALETTES_URL_SAVE)
    public String palettesDtos(@ModelAttribute LivraisonForm form, Model model) throws JsonProcessingException {
        pm.savePalettes(form);
        model.addAllAttributes(initView());
        model.addAttribute(ATT_RESULTAT, pm.getResultat());
        model.addAttribute(ConstInt.ATT_FORM, pm);
        model.addAttribute(ATT_ERREURS,pm.getErreurs());
        return ConstInt.PALETTES_JSP;
    }

    private Map<String, Object> initView() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<LivPalDto> livraisons = lm.getListLivPal();
        List<String> dates = lm.getDates(livraisons);
        Map<String, Object> map = new HashMap<>();
        map.put(ATT_LIVRAISONS, mapper.writeValueAsString(livraisons));
        map.put(ATT_DATES, dates);

        return map;
    }
}
