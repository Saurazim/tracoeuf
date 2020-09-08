package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.Categorie;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * DAO Livraison
 * Updates très fréquentes
 * @see Livraison
 */
@Repository
public interface LivraisonDao extends JpaRepository<Livraison, Integer> {
    List<Livraison> findAllByOrderByDateDesc();
    int countAllByDateAndFournisseurAndCategorie(LocalDate date, Fournisseur fournisseur, Categorie categorie);
    List<Livraison> findAllByCompteIsNull();
}
