package com.blanchard.ovobio.tracoeuf.coordinateur;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
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
     *
     * @param dto
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
            Validation.checkDate(date, ConstantesUtil.getProperty(Constantes.EXC_DATE_VIDE), ConstantesUtil.getProperty(Constantes.EXC_DATE_FORMAT));
            localDate = LocalDate.parse(date, formatter);
        }catch (Exception e){
            erreurs.put(ConstantesUtil.getProperty(Constantes.CHAMP_DATE), e.getMessage());
        }
        livraison.setDate(localDate);

        //verif fournisseur
        Fournisseur fournisseur;

        // vérifie la valeur fournisseur
        if (ConstantesUtil.getProperty(Constantes.ZERO).equals(fournisseurId)){
            try{
                Validation.checkVideString(autre,ConstantesUtil.getProperty(Constantes.EXC_FOURNISSEUR));
            }catch (Exception e){
                erreurs.put(ConstantesUtil.getProperty(Constantes.CHAMP_FOURNISSEUR), e.getMessage());
            }
            fournisseur = fournisseurService.getByNom(autre);
            if (fournisseur == null){
                fournisseur = new Fournisseur();
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
        Categorie categorie;

        try {
            Validation.checkInt(categId.toString());
        }catch (Exception e){
            erreurs.put(ConstantesUtil.getProperty(Constantes.CHAMP_CATEGORIE), e.getMessage());
        }
        categorie = categorieService.getById(categId).orElseThrow();
        livraison.setCategorie(categorie);

        //set prefixe
        //code sous forme RFFFCCC##
        StringBuilder codePrefixe  = new StringBuilder();
        codePrefixe.append(ConstantesUtil.getProperty(Constantes.CODE_PREFIXE));//R
        codePrefixe.append(fournisseur.getCode());//FFF
        codePrefixe.append(categorie.getType());//CCC
        codePrefixe.append(livraisonService.compteLivraisons(localDate,fournisseur,categorie));//##

        livraison.setPrefixCode(codePrefixe.toString());

        if (erreurs.isEmpty()){
            resultat = "Succès";
            livraisonService.save(livraison);

        } else {
            resultat = "Echec";
        }

        return livraison;
    }
}
