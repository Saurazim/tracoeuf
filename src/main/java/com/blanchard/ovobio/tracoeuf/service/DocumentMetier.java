package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.docxWriter.DocxCreater;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.printer.Printer;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;

import java.io.File;

public class DocumentMetier {
    public void impressionEtiquettesPalettes(Livraison l, int nombreCopie) {
        TemplatePalette tp = new TemplatePalette(l.getPrefixCode(), l.getDate());
        DocxCreater docCreater = new DocxCreater();
        String[] map = docCreater.creerEtiquettePalette(tp);
        if ("reussite".equals(map[0])){
            File file = new File(map[1]);
            new Printer().imprimer(file, nombreCopie);
        }

    }
}
