package com.blanchard.ovobio.tracoeuf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.dao.FournisseurDao;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Fournisseur> getById(int id) throws EntityNotFoundException{
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
    @Deprecated
    public List<Fournisseur> retourListFournisseur(boolean autresFournisseurs){
        List<Fournisseur> fournisseurs = retourListFournisseur();
        if(autresFournisseurs) {
            Fournisseur fournisseur = new Fournisseur(ConstInt.FOURNISSEUR_ID_AUTRE, ConstInt.FOURNISSEUR_AUTRE);
            fournisseurs.add(fournisseur);
        }
        return fournisseurs;
    }

    public String setCodeByNom(String nom){
        if (nom.length()>3)
            return nom.substring(0,3).toUpperCase();
        else
            return nom.toUpperCase();
    }
}
