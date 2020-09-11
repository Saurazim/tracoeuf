package com.blanchard.ovobio.tracoeuf.bo;

public class PaletteBo {
    private int id;
    private int net;
    private LivraisonBo livraisonBo;
    private String code;
    private boolean conforme;
    private String commentaires;

    public PaletteBo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public LivraisonBo getLivraisonBo() {
        return livraisonBo;
    }

    public void setLivraisonBo(LivraisonBo livraisonBo) {
        this.livraisonBo = livraisonBo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
