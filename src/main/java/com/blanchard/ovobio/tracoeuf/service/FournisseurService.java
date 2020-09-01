package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.dao.FournisseurDao;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    public String setCodeByNom(String nom){
        if (nom.length()>3)
            return nom.substring(0,3).toUpperCase();
        else
            return nom.toUpperCase();
    }
}
