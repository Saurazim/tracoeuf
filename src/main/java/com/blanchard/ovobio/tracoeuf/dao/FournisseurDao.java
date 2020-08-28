package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO Fournisseur
 * modifications possibles
 * @see Fournisseur
 */
@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur, Integer> {
    Fournisseur findById(int id);
    Fournisseur findByNom(String nom);
    List<Fournisseur> findAllByOrderByIdDesc();
    List<Fournisseur> findAllByOrderByIdAsc();
}
