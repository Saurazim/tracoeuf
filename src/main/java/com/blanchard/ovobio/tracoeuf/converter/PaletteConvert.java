package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.PaletteBo;
import com.blanchard.ovobio.tracoeuf.model.Palette;

public interface PaletteConvert {
    static PaletteBo paletteETB(Palette p){
        PaletteBo bo = new PaletteBo();
        bo.setId(p.getId());
        bo.setCode(p.getCode());
        bo.setNet(p.getNet());
        bo.setConforme(p.getConforme());
        bo.setCommentaires(p.getCommentaires());
        bo.setLivraisonBo(LivraisonConvert.livraisonETB(p.getLivraison()));

        return bo;
    }


}
