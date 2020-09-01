package com.blanchard.ovobio.tracoeuf.coordinateur;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
import com.blanchard.ovobio.tracoeuf.exceptions.ChampVideException;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.service.CategorieService;
import com.blanchard.ovobio.tracoeuf.service.FournisseurService;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;
import com.blanchard.ovobio.tracoeuf.service.Validation;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LivraisonMetier {
    @Autowired
    LivraisonService livraisonService;

    @Autowired
    FournisseurService fournisseurService;

    @Autowired
    CategorieService categorieService;

    private String resultat;
    private Map<String,String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }

    /**
     * Enregistre l'objet livraison
     * @param dto objet contenant les infos du formulaire
     * @return l'objet livraison enregistré
     */
    public Livraison saveLivraison(LivraisonDto dto){
        String date = dto.getDate();
        String fournisseurId = dto.getFournisseurId();
        String  autre = dto.getFournisseurAutre();
        Integer categId = dto.getCategorieId();
        Livraison livraison = new Livraison();

        // verif date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.MIN;

        try {
            Validation.checkDate(date, ConstInt.CHAMP_DATE);
            localDate = LocalDate.parse(date, formatter);
        }catch (Exception e){
            erreurs.put(ConstInt.CHAMP_DATE, e.getMessage());
        }
        livraison.setDate(localDate);

        //verif fournisseur
        Fournisseur fournisseur;

        // vérifie la valeur fournisseur
        if (ConstInt.FOURNISSEUR_ID_AUTRE.toString().equals(fournisseurId)){
            try{
                Validation.checkVideString(autre,ConstInt.CHAMP_FOURNISSEUR);
            }catch (Exception e){
                erreurs.put(ConstInt.CHAMP_FOURNISSEUR, e.getMessage());
            }
            fournisseur = fournisseurService.getByNom(autre);
            label:if (fournisseur == null){
                fournisseur = new Fournisseur();
                try{
                    Validation.checkVideString(autre,ConstInt.CHAMP_FOURNISSEUR);

                }catch(ChampVideException cve){
                    erreurs.put(ConstInt.CHAMP_FOURNISSEUR, cve.getMessage());
                    break label;
                }
                fournisseur.setNom(autre);
                fournisseur.setCode(fournisseurService.setCodeByNom(autre));
                fournisseurService.save(fournisseur);
            }
        } else {
            int idFournisseur = Integer.parseInt(fournisseurId);
            //appel en bdd fournisseur
            fournisseur = fournisseurService.getById(idFournisseur).orElseThrow(EntityNotFoundException::new);

        }

        livraison.setFournisseur(fournisseur);


        //verif categ
        Categorie categorie = new Categorie();

        try {
            Validation.checkInt(categId.toString());
            categorie = categorieService.getById(categId).orElseThrow();
        }catch (Exception e){
            erreurs.put(ConstInt.CHAMP_CATEGORIE, e.getMessage());
        }
        livraison.setCategorie(categorie);

        //set prefixe
        //code sous forme RFFFCCC##


        if (erreurs.isEmpty()){
            resultat = "Succès";

            String code = ConstantesUtil.getProperty(ConstExt.CODE_PREFIXE)
                    +fournisseur.getCode()
                    +categorie.getType()
                    +livraisonService.compteLivraisons(localDate,fournisseur,categorie);

            livraison.setPrefixCode(code);

            livraisonService.save(livraison);

        } else {
            resultat = "Echec";
        }

        return livraison;
    }
}
