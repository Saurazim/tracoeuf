package com.blanchard.ovobio.tracoeuf.service;


import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.converter.LivraisonConvert;
import com.blanchard.ovobio.tracoeuf.dao.LivraisonDao;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public List<LivraisonBo> findAll(){
        List<Livraison> livraisons = livraisonDao.findAll();
        List<LivraisonBo> bos = new ArrayList<>();
        for (Livraison l: livraisons) {
            LivraisonBo bo = LivraisonConvert.livraisonETB(l);
            bos.add(bo);
        }
        return bos;
    }

    public Optional<Livraison> getById(int id) {
        return livraisonDao.findById(id);
    }

    public void save(Livraison l){
        livraisonDao.save(l);
    }

    public List<LivraisonBo> getLivraisonsNonCompletes(){
        List<Livraison> livraisons = livraisonDao.findAllByCompteIsNull();
        List<LivraisonBo> bos = new ArrayList<>();
        for (Livraison l : livraisons) {
            LivraisonBo bo = LivraisonConvert.livraisonETB(l);
            bos.add(bo);
        }

        return bos;
    }
    //---------------------------------------------------------


}
