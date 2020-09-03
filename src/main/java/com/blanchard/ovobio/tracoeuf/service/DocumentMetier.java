package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.docxWriter.DocxCreater;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.printer.Printer;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;

import java.io.File;
import java.time.LocalDate;

public class DocumentMetier {
    public void impressionEtiquettesPalettes(Livraison l, int nombreCopie) {
        //crée le doc à base du template
        String[] map = creerEtiquettePalette(l.getPrefixCode(), l.getDate());
        //imprime le doc
        if ("reussite".equals(map[0])) {
            impressionFichier(map[1], nombreCopie);
        }

    }

    public void impressionFichier(String nom, int nbCopies) {
        File file = new File(nom);
        new Printer().imprimer(file, nbCopies);
    }

    public String[] creerEtiquettePalette(String prefix, LocalDate date) {
        return new DocxCreater().creerEtiquettePalette(new TemplatePalette(prefix, date));
    }
}
