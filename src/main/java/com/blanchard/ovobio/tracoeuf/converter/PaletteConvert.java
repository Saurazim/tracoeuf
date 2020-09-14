package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.PaletteBo;
import com.blanchard.ovobio.tracoeuf.dto.AdminPalDto;
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

    static AdminPalDto adminPalBTD(PaletteBo bo){
        AdminPalDto dto = new AdminPalDto();

        dto.setId(bo.getId());
        dto.setReference(bo.getCode());
        dto.setNet(bo.getNet());
        dto.setLivraisonId(bo.getLivraisonBo().getId());
        dto.setConforme(bo.isConforme());
        dto.setCommentaires(bo.getCommentaires());

        return dto;
    }
}
