package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.FournisseurBo;
import com.blanchard.ovobio.tracoeuf.model.Fournisseur;

public interface FournisseurConvert {
    static FournisseurBo fournisseurETB(Fournisseur f){
        return new FournisseurBo(f.getId(), f.getNom(), f.getCode());
    }


}
