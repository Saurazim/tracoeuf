package com.blanchard.ovobio.tracoeuf.bo;

public class TareBo {
    private Integer tareNbAlveole;
    private String tareTypePalette;
    private Integer tare;
    private Boolean checkTare;
    private Integer tareFinal;

    public TareBo(Integer tareNbAlveole, String tareTypePalette, Integer tare, Boolean checkTare) {
        this.tareNbAlveole = tareNbAlveole;
        this.tareTypePalette = tareTypePalette;
        this.tare = tare;
        this.checkTare = checkTare;
    }

    public Integer getTareNbAlveole() {
        return tareNbAlveole;
    }

    public void setTareNbAlveole(Integer tareNbAlveole) {
        this.tareNbAlveole = tareNbAlveole;
    }

    public String getTareTypePalette() {
        return tareTypePalette;
    }

    public void setTareTypePalette(String tareTypePalette) {
        this.tareTypePalette = tareTypePalette;
    }

    public Integer getTare() {
        return tare;
    }

    public void setTare(Integer tare) {
        this.tare = tare;
    }

    public Boolean getCheckTare() {
        return checkTare;
    }

    public void setCheckTare(Boolean checkTare) {
        this.checkTare = checkTare;
    }

    public Integer getTareFinal() {
        return tareFinal;
    }

    public void setTareFinal(Integer tareFinal) {
        this.tareFinal = tareFinal;
    }
}
