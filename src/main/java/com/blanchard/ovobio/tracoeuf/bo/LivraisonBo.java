package com.blanchard.ovobio.tracoeuf.bo;

public class LivraisonBo {
    private String prefix;
    private Integer id;

    public LivraisonBo(){}

    public LivraisonBo(String prefix, Integer id) {
        this.prefix = prefix;
        this.id = id;
    }

    @Override
    public String toString() {
        return "livraisonBo{" +
                "prefix='" + prefix + '\'' +
                ", id=" + id +
                '}';
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
