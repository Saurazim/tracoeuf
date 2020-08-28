package com.blanchard.ovobio.tracoeuf.dto;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class PaletteDto {
    private Integer idColumn;
    private String poids;
    private String tare = ConstantesUtil.getProperty(Constantes.ZERO);
    private String net;
    private boolean conforme = ConstantesUtil.getPropertyToBool(Constantes.FALSE);
    private String commentaires;

    public PaletteDto(){}

    public PaletteDto(Integer idColumn, String poids, String tare, String net, boolean conforme, String commentaires) {
        this.idColumn = idColumn;
        this.poids = poids;
        this.tare = tare;
        this.net = net;
        this.conforme = conforme;
        this.commentaires = commentaires;
    }

    public Integer getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(Integer idColumn) {
        this.idColumn = idColumn;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTare() {
        return tare;
    }

    public void setTare(String tare) {
        this.tare = tare;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
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
