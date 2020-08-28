package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.dao.LivraisonPaletteDao;
import com.blanchard.ovobio.tracoeuf.model.LivraisonPalette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * appelle les méthodes du dao
 */
@Service
public class LivraisonPaletteService {
    @Autowired
    LivraisonPaletteDao livraisonPaletteDao;

    public void saveAll(List<LivraisonPalette> palettes){
        livraisonPaletteDao.saveAll(palettes);
    }
}
