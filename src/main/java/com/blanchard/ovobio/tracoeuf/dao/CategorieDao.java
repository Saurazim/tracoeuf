package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO Catégorie
 * READ ONLY sauf en cas de changement des normes
 * @see Categorie
 */
@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer> {
}
