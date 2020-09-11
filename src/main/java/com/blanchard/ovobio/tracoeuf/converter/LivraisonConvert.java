package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.dto.AdminLivDto;
import com.blanchard.ovobio.tracoeuf.dto.LivPalDto;
import com.blanchard.ovobio.tracoeuf.model.Livraison;

import java.time.LocalDate;

public interface LivraisonConvert {

    static LivraisonBo livraisonETB(Livraison l){
        LivraisonBo bo = new LivraisonBo();
        bo.setId(l.getId());
        bo.setDate(l.getDate());
        bo.setFournisseurBo(FournisseurConvert.fournisseurETB(l.getFournisseur()));
        bo.setCategorieBo(CategorieConvert.categorieETB(l.getCategorie()));
        bo.setNetTotal(l.getNetTotal());
        bo.setPrefix(l.getPrefixCode());
        bo.setCompte(l.getCompte());

        return bo;
    }

    static LivPalDto livPalBTD(LivraisonBo bo){
        LivPalDto dto = new LivPalDto();
        dto.setId(bo.getId());
        dto.setDate(bo.getDate().toString());
        dto.setPrefix(bo.getPrefix());

        return dto;
    }

    static LivraisonBo LivPalDTB(LivPalDto dto){
        LivraisonBo bo = new LivraisonBo();
        bo.setId(dto.getId());
        bo.setDate(LocalDate.parse(dto.getDate()));
        bo.setPrefix(dto.getPrefix());
        return bo;
    }

    static AdminLivDto adminLivBTD(LivraisonBo bo){
        AdminLivDto dto = new AdminLivDto();
        dto.setId(bo.getId());
        dto.setDate(bo.getDate().toString());
        dto.setFournisseur(bo.getFournisseurBo().getNom());
        dto.setCategorie(bo.getCategorieBo().getType());
        dto.setNbPalette(bo.getCompte());
        dto.setPrefix(bo.getPrefix());
        dto.setNetTotal(bo.getNetTotal());

        return dto;
    }
}
