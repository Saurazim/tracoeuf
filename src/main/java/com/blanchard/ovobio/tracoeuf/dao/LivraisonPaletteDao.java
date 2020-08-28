package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.LivraisonPalette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO LivraisonPalettes
 * Updates très fréquentes
 * peu appelée par livraison
 * @see LivraisonPalette
 */
@Repository
public interface LivraisonPaletteDao extends JpaRepository<LivraisonPalette, Integer> {
}
