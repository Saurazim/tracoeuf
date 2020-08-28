package com.blanchard.ovobio.tracoeuf.model;

import com.blanchard.ovobio.tracoeuf.exceptions.SubAboveZeroFalseException;
import com.blanchard.ovobio.tracoeuf.util.MathsUtil;

import javax.persistence.*;

/**
 * objet palette de livraison
 * une palette est liée à une livraison
 */
@Entity
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer net;
    @ManyToOne
    @JoinColumn(name = "livraisonId", nullable = false)
    private Livraison livraison;
    private String code;
    private Boolean conforme;
    private String commentaires;

    public Palette(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNet() {
        return net;
    }

    public void setNet(Integer net) {
        this.net = net;
    }

    /**
     * Détermine le net à partir du brut et de la tare
     * @param brut
     * @param tarePal
     * @throws SubAboveZeroFalseException si résultat négatif
     */
    public void setNet(Integer brut, Integer tarePal) throws SubAboveZeroFalseException {
        this.net = MathsUtil.subAboveZero(brut,tarePal);
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
