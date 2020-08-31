package com.blanchard.ovobio.tracoeuf.controller.vue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blanchard.ovobio.tracoeuf.DocxWriter.DocxCreater;
import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.coordinateur.LivraisonMetier;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.service.CategorieService;
import com.blanchard.ovobio.tracoeuf.service.FournisseurService;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;

import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;
import com.blanchard.ovobio.tracoeuf.util.FormUtil;
import org.checkerframework.checker.formatter.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * controller de la page '/livraison'
 */
@Controller
public class LivraisonController {
    @Autowired
    LivraisonMetier livraisonMetier;

    @Autowired
    LivraisonService livraisonService;

    @Autowired
    FournisseurService fournisseurService;

    @Autowired
    CategorieService categorieService;

    private static final String URL_LIVRAISON = "livraison";
    public static final String ATT_FORM = "form";
    public static final String ATT_DTO = "dto";
    public static final String ATT_FOURNISSEURS = "fournisseurs";
    public static final String ATT_CATEGORIES = "categories";

    /**
     * Initialise les attributs récurrents
     * livraisons, fournisseurs, catégories
     * @return une hashmap contenant les attributs
     */
    private Map<String, Object> initVue(){
        //List<Livraison> livraisons = livraisonService.retourListLivraison();
        List<Fournisseur> fournisseurs = fournisseurService.retourListFournisseur();
        List<Categorie> categories = categorieService.retourAllCateg();

        Map<String, Object> mapper = new HashMap<>();
        //mapper.put(ATT_LIVRAISON_LIST, livraisons);
        mapper.put(ATT_FOURNISSEURS, fournisseurs);
        mapper.put(ATT_CATEGORIES, categories);

        return mapper;
    }

    @GetMapping(URL_LIVRAISON)
    public String livraisonView(Model model){
        model.addAllAttributes(initVue());
        LivraisonDto dto = new LivraisonDto();
        model.addAttribute(ATT_DTO, dto);
        return "1_livraison";//ConstantesUtil.getProperty(Constantes.LIVRAISON_JSP);
    }

    @PostMapping(URL_LIVRAISON)
    public String livraisonPost(@ModelAttribute LivraisonDto dto, Model mm){
        Livraison l = livraisonMetier.saveLivraison(dto);
        if (livraisonMetier.getErreurs().isEmpty()){
            String ref = l.getPrefixCode();
            LivraisonBo bo = new LivraisonBo();
            TemplatePalette tp = new TemplatePalette(ref, FormUtil.dateToString(l.getDate()));

            new DocxCreater().createDocx(tp);
            bo.setPrefix(ref);
            bo.setId(l.getId());
            mm.addAttribute("bo",bo);
            return "forward:/palettes";
        } else {
            mm.addAllAttributes(initVue());
            mm.addAttribute(ATT_DTO, dto);
            mm.addAttribute(ATT_FORM, livraisonMetier);
            return "1_livraison";
        }

    }
}
