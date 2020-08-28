package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.dao.FournisseurDao;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * appel des méthodes du dao
 */
@Service
public class FournisseurService {
    @Autowired
    FournisseurDao fournisseurDao;

    public List<Fournisseur> retourListFournisseur(){
        return fournisseurDao.findAllByOrderByIdDesc();
    }

    public Fournisseur getById(int id){
        return fournisseurDao.findById(id);
    }

    public Fournisseur getByNom(String nom){
        return fournisseurDao.findByNom(nom);
    }

    public void save(Fournisseur fournisseur){ fournisseurDao.save(fournisseur);}

    /**
     * fonction retournant l'ensemble des fournisseurs
     * et rajoute un fournisseur fictif dans le cas d'un ajout de choix pour le select html
     * @deprecated
     * @param autresFournisseurs true si autre fournisseur  à rajouter
     * @return tous les fournisseurs plus une ligne
     */
    public List<Fournisseur> retourListFournisseur(boolean autresFournisseurs){
        List<Fournisseur> fournisseurs = new ArrayList<>();

        Fournisseur fournisseur = new Fournisseur(ConstantesUtil.getPropertyToInt(Constantes.ZERO), ConstantesUtil.getProperty(Constantes.FOURNISSEUR_AUTRE));//(0,"autre fournisseur")

        fournisseurs = retourListFournisseur();
        fournisseurs.add(fournisseur);

        return fournisseurs;
    }

    public String setCodeByNom(String nom){
        return nom.substring(0,3).toUpperCase();
    }
}
