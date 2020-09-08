package com.blanchard.ovobio.tracoeuf.service;

import com.blanchard.ovobio.tracoeuf.bo.LivraisonBo;
import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.docxWriter.DocxCreater;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.printer.Printer;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

import static java.lang.Math.round;

public class DocumentMetier {
    private static final String input = ConstantesUtil.getProperty(ConstExt.INPUT_PATH);
    private static final String output = ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH);
    private static final String extPdf = ".pdf";
    private static final String extFo = ".fo";
    private static final String DOCX = ConstantesUtil.getProperty(ConstExt.PATH_OUTPUT_DOCX);
    private static final String PDF =ConstantesUtil.getProperty(ConstExt.PATH_OUTPUT_PDF);


    public String impressionEtiquettesPalettes(LivraisonBo l) {
        //crée le doc à base du template
        String[] map = creerEtiquettePalette(l.getPrefix(), l.getDate(), l.getCategorieBo().getType());
        //imprime le doc
        if ("reussite".equals(map[0])) {
            impressionFichier(map[1]);
            System.out.println("printing done");
        }
        return map[0];
    }

    public void impressionFichier(String nom) {
        File file = new File(nom);
        new Printer().imprimer(file);
    }

    public String[] creerEtiquettePalette(String prefix, LocalDate date, String categorie) {
        String[] map = new DocxCreater().creerEtiquettePalette(new TemplatePalette(prefix, date, categorie));
        try {
            String nomPdf = conversionDocxToPdf(map[1], output+PDF);
            map[1] = nomPdf;
        }catch (Exception e){
            map[0] = "Erreurs";
            e.printStackTrace();
        }

        return map;
    }

    public String conversionDocxToPdf(String input, String output) throws Docx4JException, FileNotFoundException {
        //conversion nom
        File file = new File(input);
        String name = file.getName();
        name = name.substring(0,name.lastIndexOf('.'));
        String namePdf = output+name+extPdf;
        //settings conversion
        FOSettings foSettings = Docx4J.createFOSettings();

        WordprocessingMLPackage wmlp = WordprocessingMLPackage.load(file);
        FileOutputStream os = new FileOutputStream(namePdf);

        foSettings.setFoDumpFile(new File(input+extFo));
        foSettings.setWmlPackage(wmlp);

        Docx4J.toFO(foSettings,os,Docx4J.FLAG_EXPORT_PREFER_XSL);

        return namePdf;
    }
}
