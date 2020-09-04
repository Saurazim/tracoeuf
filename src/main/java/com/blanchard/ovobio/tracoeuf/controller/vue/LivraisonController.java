package com.blanchard.ovobio.tracoeuf.controller.vue;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.coordinateur.LivraisonMetier;
import com.blanchard.ovobio.tracoeuf.dto.ImprDto;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.service.CategorieService;
import com.blanchard.ovobio.tracoeuf.service.DocumentMetier;
import com.blanchard.ovobio.tracoeuf.service.FournisseurService;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller de la page '/livraison'
 */
@Controller
public class LivraisonController {

    @Autowired
    LivraisonMetier livraisonMetier;

    @Autowired
    FournisseurService fournisseurService;

    @Autowired
    CategorieService categorieService;

    private static final String PATH = ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH);


    private static final String ATT_DTO = "dto";
    private static final String ATT_FOURNISSEURS = "fournisseurs";
    private static final String ATT_CATEGORIES = "categories";
    private static final String ATT_BO = "bo";
    DocumentMetier documentMetier = new DocumentMetier();

    /**
     * Initialise les attributs récurrents
     * livraisons, fournisseurs, catégories
     * @return une hashmap contenant les attributs
     */
    private Map<String, Object> initVue(){
        List<Fournisseur> fournisseurs = fournisseurService.retourListFournisseur();
        List<Categorie> categories = categorieService.retourAllCateg();

        Map<String, Object> mapper = new HashMap<>();
        mapper.put(ATT_FOURNISSEURS, fournisseurs);
        mapper.put(ATT_CATEGORIES, categories);

        return mapper;
    }

    @GetMapping(ConstInt.LIVRAISON_URL)
    public String livraisonView(Model model){
        model.addAllAttributes(initVue());
        LivraisonDto dto = new LivraisonDto();
        model.addAttribute(ATT_DTO, dto);
        return ConstInt.LIVRAISON_JSP;
    }

    @PostMapping(ConstInt.LIVRAISON_URL)
    public String livraisonPost(@ModelAttribute LivraisonDto dto, Model mm){
        Livraison l = livraisonMetier.saveLivraison(dto);
        mm.addAllAttributes(initVue());
        mm.addAttribute(ATT_DTO, dto);
        mm.addAttribute(ConstInt.ATT_FORM, livraisonMetier);
        if (livraisonMetier.getErreurs().isEmpty()){
            documentMetier.impressionEtiquettesPalettes(l, dto.getNombrePalette());
        }
        return ConstInt.LIVRAISON_JSP;


    }

    @PostMapping("/impression")
    public ResponseEntity<?> impressionDocLivraison(@RequestBody ImprDto impr) {
        //impression
        try {
            System.out.println(impr.getNom());

            documentMetier.impressionFichier(PATH+impr.getNom(),1);
            impr.setMsg("success");
            return ResponseEntity.ok(impr);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"msg\":\"erreur\"}");
        }
    }
}
