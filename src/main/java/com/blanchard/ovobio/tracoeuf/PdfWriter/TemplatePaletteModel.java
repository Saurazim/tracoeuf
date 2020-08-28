package com.blanchard.ovobio.tracoeuf.PdfWriter;

public class TemplatePaletteModel {
    private String reference;
    private String date;

    public TemplatePaletteModel(String reference, String date) {
        this.reference = reference;
        this.date = date;
    }

    public String getRef() {
        return reference;
    }

    public void setRef(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
