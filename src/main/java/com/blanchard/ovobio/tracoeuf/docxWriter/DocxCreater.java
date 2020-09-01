package com.blanchard.ovobio.tracoeuf.docxWriter;




import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.HashMap;

public class DocxCreater {
    private static final String INPUT_PATH = ConstantesUtil.getProperty(ConstExt.INPUT_PATH);
    private static final String OUTPUT_PATH = ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH);
    private static final String DOC = "template_palette.docx";
    private static final String REF = "reference";
    private static final String DATE = "date";


    public String[] creerEtiquettePalette(TemplatePalette tp) {
        //init
        WordprocessingMLPackage wmlPackage = new WordprocessingMLPackage();
        String nom = OUTPUT_PATH+tp.getNom();
        String issue="echec";
        int ct=0;
        try{
            wmlPackage = Docx4J.load(new File(INPUT_PATH+DOC));
        } catch (Docx4JException d4je){
            d4je.printStackTrace();
            System.out.println("pas de template valable dans l'application : "+INPUT_PATH+DOC);
            ct--;
        }
        MainDocumentPart docPart = wmlPackage.getMainDocumentPart();
        //get mapping
        HashMap<String,String> mappings = new HashMap<>();
        mappings.put(REF,tp.getRef());
        mappings.put(DATE,tp.getDate());
        //timer
        long start = System.currentTimeMillis();

        try{
            docPart.variableReplace(mappings);
        } catch (Docx4JException | JAXBException e) {
            e.printStackTrace();
            ct--;
        }

        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Time: "+total);

        String[] map = new String[2];
        //save
        try {
            wmlPackage.save(new File(nom));
            if (ct>=0)
                issue="reussite";
        }  catch (Docx4JException d4je){
            d4je.printStackTrace();
        }
        map[0] = issue;
        map[1] = nom;
        return map;
    }
}
