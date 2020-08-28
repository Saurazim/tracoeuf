package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.dao.CategorieDao;
import com.blanchard.ovobio.tracoeuf.model.Categorie;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * appel des méthodes du DAO
 */
@Service
public class CategorieService {
    @Autowired
    CategorieDao categorieDao;

    public List<Categorie> retourAllCateg(){
        return categorieDao.findAll();
    }

    public Categorie getById(int id){
        return categorieDao.findById(id);
    }
}
