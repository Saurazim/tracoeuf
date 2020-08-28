package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.coordinateur.LivraisonMetier;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.service.CategorieService;
import com.blanchard.ovobio.tracoeuf.service.FournisseurService;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.*;

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
    public static final String LISTLIVRAISON = "listBean";
    public static final String SD_FORMAT = "sdf";
    public static final String ATT_FORM = "form";
    public static final String ATT_LIVRAISON = "livraison";
    public static final String ATT_LIVRAISON_LIST = "livraisons";
    public static final String ATT_LIVRAISON_DTO = "LivraisonDto";
    public static final String ATT_LIVRAISON_FORM = "livraisonForm";
    public static final String ATT_FOURNISSEURS = "fournisseurs";
    public static final String ATT_CATEGORIES = "categories";


    /**
     * return view by get method
     * @param model à remplir
     * @return view
     */
//    @GetMapping(URL_LIVRAISON)
//    public String livraison(Model model)
//    {
//        model.addAllAttributes(initVue());
//
//        LivraisonDto livraisonDto = new LivraisonDto();
//        LivraisonForm livraisonForm = new LivraisonForm();
//        livraisonForm.getList().add(livraisonDto);
//        model.addAttribute(ATT_LIVRAISON_FORM, livraisonForm);
//
//        return ConstantesUtil.getProperty(Constantes.LIVRAISON_JSP);
//    }

    /**
     * Traitement des informations du formulaire
     * @param livraisonForm Objet contenant les différents DTO représentant les palettes arrivées
     * @param model à remplir
     * @return view
     */
//    @PostMapping(URL_LIVRAISON)
//    public String doPost(@ModelAttribute LivraisonForm livraisonForm, Model model) {
//
//        livraisonService.saveLivraison(livraisonForm);
//
//        model.addAllAttributes(initVue());
//
//        model.addAttribute(ATT_FORM, livraisonService);
//        model.addAttribute(ATT_LIVRAISON_FORM, livraisonForm);
//        return ConstantesUtil.getProperty(Constantes.LIVRAISON_JSP);
//    }

    /**
     * Initialise les attributs récurrents
     * livraisons, fournisseurs, catégories
     * @return une hashmap contenant les attributs
     */
    private Map<String, Object> initVue(){
        List<Livraison> livraisons = livraisonService.retourListLivraison();
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
        model.addAttribute("dto", dto);
        return "1_livraison";//ConstantesUtil.getProperty(Constantes.LIVRAISON_JSP);
    }

    @PostMapping(URL_LIVRAISON)
    public String livraisonPost(@ModelAttribute LivraisonDto dto, ModelMap mm){
        Livraison livraison = livraisonMetier.saveLivraison(dto);
        if (livraisonMetier.getErreurs().isEmpty()){
            LivraisonBo bo = new LivraisonBo();
            bo.setPrefix(livraison.getPrefixCode());
            bo.setId(livraison.getId());
            mm.addAttribute("bo",bo);
            return "forward:/palettes";
        } else {
            Model model = new ConcurrentModel();
            model.addAttribute(ATT_FORM, livraisonMetier);
            return "1_livraison";
        }

    }
}
