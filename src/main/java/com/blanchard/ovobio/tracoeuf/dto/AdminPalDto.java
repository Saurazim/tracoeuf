package com.blanchard.ovobio.tracoeuf.dto;

public class AdminPalDto {
    private int id;
    private String reference;
    private int net;
    private int livraisonId;
    private Boolean conforme;
    private String commentaires;

    public AdminPalDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Boolean getConforme() {
        return conforme;
    }

    public void setConforme(Boolean conforme) {
        this.conforme = conforme;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
