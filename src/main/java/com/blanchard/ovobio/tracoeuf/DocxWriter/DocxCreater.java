package com.blanchard.ovobio.tracoeuf.DocxWriter;




import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;

public class DocxCreater {
    private static final String INPUT_PATH = ConstantesUtil.getProperty(Constantes.INPUT_PATH);
    private static final String OUTPUT_PATH = ConstantesUtil.getProperty(Constantes.OUTPUT_PATH);
    private static final String DOC = "template_palette.docx";
    private static final String REF = "reference";
    private static final String DATE = "date";


    public void createDocx(TemplatePalette tp) {
        //init
        WordprocessingMLPackage wmlPackage = new WordprocessingMLPackage();
        try{
            wmlPackage = Docx4J.load(new File(INPUT_PATH+DOC));
        } catch (Docx4JException d4je){
            d4je.printStackTrace();
            System.out.println("pas de template valable dans l'application : "+INPUT_PATH+DOC);
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
        } catch (Docx4JException d4je){
            d4je.printStackTrace();
        } catch (JAXBException je){
            je.printStackTrace();
        }

        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Time: "+total);

        //save
        try {
            wmlPackage.save(new File(OUTPUT_PATH+tp.getNom()));
        }  catch (Docx4JException d4je){
            d4je.printStackTrace();
        }
    }
}
