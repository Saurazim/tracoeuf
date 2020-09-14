package com.blanchard.ovobio.tracoeuf.coordinateur;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.bo.PaletteBo;
import com.blanchard.ovobio.tracoeuf.converter.LivraisonConvert;
import com.blanchard.ovobio.tracoeuf.converter.PaletteConvert;
import com.blanchard.ovobio.tracoeuf.dto.AdminLivDto;
import com.blanchard.ovobio.tracoeuf.dto.AdminPalDto;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;
import com.blanchard.ovobio.tracoeuf.service.PaletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminLivMetier {
    @Autowired
    LivraisonService ls;

    @Autowired
    PaletteService ps;

    public List<AdminLivDto> getListLivraisons(){
        List<LivraisonBo> bos = ls.findAll();
        List<AdminLivDto> dtos = new ArrayList<>();
        for (LivraisonBo bo : bos){
            AdminLivDto dto = LivraisonConvert.adminLivBTD(bo);
            dtos.add(dto);
        }

        return dtos;
    }

    public List<AdminPalDto> getListPalettes(){
        List<PaletteBo> bos = ps.findAll();
        List<AdminPalDto> dtos = new ArrayList<>();
        for (PaletteBo bo : bos){
            AdminPalDto dto = PaletteConvert.adminPalBTD(bo);
            dtos.add(dto);
        }
        return dtos;
    }
}
