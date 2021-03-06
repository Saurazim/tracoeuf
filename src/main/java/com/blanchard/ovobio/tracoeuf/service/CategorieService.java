package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.dao.CategorieDao;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * appel des méthodes du DAO
 */
@Service
public class CategorieService {
    @SuppressWarnings("unused")
    @Autowired
    CategorieDao categorieDao;

    public List<Categorie> retourAllCateg(){
        return categorieDao.findAll();
    }

    public Optional<Categorie> getById(int id){
        return categorieDao.findById(id);
    }
}
