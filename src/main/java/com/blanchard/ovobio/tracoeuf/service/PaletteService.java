package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.dao.PaletteDao;
import com.blanchard.ovobio.tracoeuf.model.Palette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * appelle les méthodes du dao
 */
@Service
public class PaletteService {
    @Autowired
    PaletteDao paletteDao;

    public void saveAll(List<Palette> palettes){
        paletteDao.saveAll(palettes);
    }
}
