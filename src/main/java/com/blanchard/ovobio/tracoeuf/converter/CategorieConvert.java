package com.blanchard.ovobio.tracoeuf.converter;

import com.blanchard.ovobio.tracoeuf.bo.CategorieBo;
import com.blanchard.ovobio.tracoeuf.model.Categorie;

public interface CategorieConvert {
    static CategorieBo categorieETB(Categorie c){
        return new CategorieBo(c.getId(),c.getType());
    }
}
