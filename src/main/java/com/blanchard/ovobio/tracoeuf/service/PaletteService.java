package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.bo.PaletteBo;
import com.blanchard.ovobio.tracoeuf.converter.PaletteConvert;
import com.blanchard.ovobio.tracoeuf.dao.PaletteDao;
import com.blanchard.ovobio.tracoeuf.model.Palette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<PaletteBo> findAll(){
        List<Palette> palettes = paletteDao.findAll();
        List<PaletteBo> bos = new ArrayList<>();
        for (Palette p : palettes){
            PaletteBo bo = PaletteConvert.paletteETB(p);
            bos.add(bo);
        }
        return bos;
    }
}
