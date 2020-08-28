package com.blanchard.ovobio.tracoeuf.service;


import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.dao.LivraisonDao;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonDto;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivraisonService {
    @Autowired
    LivraisonDao livraisonDao;

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


    //----------------------------------------------------

    /**
     * appel des méthodes du dao
     */

    public List<Livraison> retourListLivraison(){
        return livraisonDao.findAllByOrderByDateDesc();
    }

    public int compteLivraisons(LocalDate localDate, Fournisseur fournisseur, Categorie categorie){
        return livraisonDao.countAllByDateAndFournisseurAndCategorie(localDate,fournisseur,categorie);
    }

    public void saveAll(List<Livraison> livraisons){
        livraisonDao.saveAll(livraisons);
    }

    public List<Livraison> findAll(){
        return livraisonDao.findAll();
    }
    //---------------------------------------------------------

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
            fournisseur = fournisseurService.getById(idFournisseur);
        }

        livraison.setFournisseur(fournisseur);


        //verif categ
        Categorie categorie;

        try {
            Validation.checkInt(categId, ConstantesUtil.getProperty(Constantes.EXC_CATEGORIE));
        }catch (Exception e){
            erreurs.put(ConstantesUtil.getProperty(Constantes.CHAMP_CATEGORIE), e.getMessage());
        }
        categorie = categorieService.getById(categId);
        livraison.setCategorie(categorie);

        //set prefixe
        //code sous forme RFFFCCC##
        StringBuilder codePrefixe  = new StringBuilder();
        codePrefixe.append(ConstantesUtil.getProperty(Constantes.CODE_PREFIXE));//R
        codePrefixe.append(fournisseur.getCode());//FFF
        codePrefixe.append(categorie.getType());//CCC
        codePrefixe.append(compteLivraisons(localDate,fournisseur,categorie));//##

        livraison.setPrefixCode(codePrefixe.toString());

        return livraison;
    }
}
