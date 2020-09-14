package com.blanchard.ovobio.tracoeuf.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * conteneur des dto de livraison
 */
public class LivraisonForm {
    private List<PaletteDto> list = new ArrayList<>();
    private Integer id;
    private String prefix;
    private String bon;

    public List<PaletteDto> getList() {
        return list;
    }

    public void setList(List<PaletteDto> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBon() {
        return bon;
    }

    public void setBon(String bon) {
        this.bon = bon;
    }
}
