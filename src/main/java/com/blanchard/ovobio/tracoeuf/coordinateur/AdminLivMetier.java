package com.blanchard.ovobio.tracoeuf.coordinateur;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.converter.LivraisonConvert;
import com.blanchard.ovobio.tracoeuf.dto.AdminLivDto;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AdminLivMetier {
    @Autowired
    LivraisonService ls;

    public List<AdminLivDto> getListLivraisons(){
        List<LivraisonBo> bos = ls.findAll();
        List<AdminLivDto> dtos = new ArrayList<>();
        for (LivraisonBo bo : bos){
            AdminLivDto dto = LivraisonConvert.adminLivBTD(bo);
            dtos.add(dto);
        }

        return dtos;
    }


}
