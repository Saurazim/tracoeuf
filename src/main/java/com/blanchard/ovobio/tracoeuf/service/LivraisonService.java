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

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LivraisonService {
    @Autowired
    LivraisonDao livraisonDao;




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

    public List<Livraison> findAll(){
        return livraisonDao.findAll();
    }

    public Optional<Livraison> getById(int id) {
        return livraisonDao.findById(id);
    }

    public void save(Livraison l){livraisonDao.save(l);}
    //---------------------------------------------------------


}
