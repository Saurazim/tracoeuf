package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.dto.LivPalDto;
import com.blanchard.ovobio.tracoeuf.model.Livraison;

public class LivraisonConvert {
    public LivraisonBo livraisonETB(Livraison l){
        LivraisonBo bo = new LivraisonBo();
        bo.setId(l.getId());
        bo.setDate(l.getDate().toString());
        bo.setFournisseurId(l.getFournisseur().getId());
        bo.setCategorieId(l.getCategorie().getId());
        bo.setNetTotal(l.getNetTotal());
        bo.setPrefix(l.getPrefixCode());
        bo.setCompte(l.getCompte());

        return bo;
    }

    public LivPalDto livPalBTD(LivraisonBo bo){
        LivPalDto dto = new LivPalDto();
        dto.setId(bo.getId());
        dto.setDate(bo.getDate());
        dto.setPrefix(bo.getPrefix());

        return dto;
    }

    public LivraisonBo LivPalDTB(LivPalDto dto){
        LivraisonBo bo = new LivraisonBo();
        bo.setId(dto.getId());
        bo.setDate(dto.getDate());
        bo.setPrefix(dto.getPrefix());
        return bo;
    }
}
