package com.blanchard.ovobio.tracoeuf.dao;

import com.blanchard.ovobio.tracoeuf.model.Palette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO LivraisonPalettes
 * Updates très fréquentes
 * peu appelée par livraison
 * @see Palette
 */
@Repository
public interface PaletteDao extends JpaRepository<Palette, Integer> {
}
