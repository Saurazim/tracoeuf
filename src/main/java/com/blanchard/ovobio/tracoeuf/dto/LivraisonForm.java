package com.blanchard.ovobio.tracoeuf.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * conteneur des dto de livraison
 */
public class LivraisonForm {
    private List<PaletteDto> list = new ArrayList<>();

    public List<PaletteDto> getList() {
        return list;
    }

    public void setList(List<PaletteDto> list) {
        this.list = list;
    }
}
