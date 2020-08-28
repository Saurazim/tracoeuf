package com.blanchard.ovobio.tracoeuf.PdfWriter;




import com.aspose.words.Document;
import com.aspose.words.ReportingEngine;
import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

import java.io.IOException;
import java.time.LocalDate;

public class PdfCreater {
    private static final String PATH = ConstantesUtil.getProperty(Constantes.PDF_PATH);

    public void createPdf(String nom) throws Exception {
        //crée le document avec docx template
        Document doc = new Document(PATH + "template_palette.docx");
        TemplatePaletteModel tpm = new TemplatePaletteModel("RFFFCCCCX", LocalDate.now().toString());
        ReportingEngine engine = new ReportingEngine();
        engine.buildReport(doc,tpm, "p");
        doc.save("word.docx");

    }
}
