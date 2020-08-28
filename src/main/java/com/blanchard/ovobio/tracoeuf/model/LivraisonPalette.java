package com.blanchard.ovobio.tracoeuf.model;

import com.blanchard.ovobio.tracoeuf.exceptions.SubAboveZeroFalseException;
import com.blanchard.ovobio.tracoeuf.util.MathsUtil;

import javax.persistence.*;

/**
 * objet palette de livraison
 * une palette est liée à une livraison
 */
@Entity
public class LivraisonPalette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer brut;
    private Integer tarePal;
    private Integer net;
    @ManyToOne
    @JoinColumn(name = "livraisonId", nullable = false)
    private Livraison livraison;
    private String code;

    public LivraisonPalette(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrut() {
        return brut;
    }

    public void setBrut(Integer brut) {
        this.brut = brut;
    }

    public Integer getTarePal() {
        return tarePal;
    }

    public void setTarePal(Integer tarePal) {
        this.tarePal = tarePal;
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
}
