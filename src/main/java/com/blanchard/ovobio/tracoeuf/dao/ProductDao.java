package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO DAO test
 * sert de référence
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByNomLike(String recherche);

    @Query(value = "SELECT p.id, p.nom, p.prix, p.prix_achat from Product p WHERE p.prix > :prixLimite", nativeQuery = true)
    List<Product> chercherProduitPlusCher(@Param("prixLimite") int prix);
}
