package com.blanchard.ovobio.tracoeuf.dto;

public class AdminPalDto {
    private String reference;
    private int net;
    private int livraisonId;

    public AdminPalDto(){}

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getLivraisonId() {
        return livraisonId;
    }

    public void setLivraisonId(int livraisonId) {
        this.livraisonId = livraisonId;
    }
}
