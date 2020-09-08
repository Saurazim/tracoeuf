package com.blanchard.ovobio.tracoeuf.bo;

import java.time.LocalDate;

public class LivraisonBo {
    private int id;
    private LocalDate date;
    private FournisseurBo fournisseurBo;
    private CategorieBo categorieBo;
    private Integer netTotal;
    private String prefix;
    private Integer compte;


    public LivraisonBo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FournisseurBo getFournisseurBo() {
        return fournisseurBo;
    }

    public void setFournisseurBo(FournisseurBo fournisseurBo) {
        this.fournisseurBo = fournisseurBo;
    }

    public CategorieBo getCategorieBo() {
        return categorieBo;
    }

    public void setCategorieBo(CategorieBo categorieBo) {
        this.categorieBo = categorieBo;
    }

    public Integer getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Integer netTotal) {
        this.netTotal = netTotal;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getCompte() {
        return compte;
    }

    public void setCompte(Integer compte) {
        this.compte = compte;
    }
}
