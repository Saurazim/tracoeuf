package com.blanchard.ovobio.tracoeuf.printer;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.*;

import static java.lang.Math.round;

public class Printer {
    private static final String INPUT = ConstantesUtil.getProperty(ConstExt.INPUT_PATH);
    private static final String OUTPUT = ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH);
    private static final String PRINTER = ConstantesUtil.getProperty(ConstExt.PRINTER_NAME);

    public void imprimer(File file, float nombreCopie) {
        int nbcopies = round(nombreCopie/2);
        PrintService service = PrintUtil.findPrintService(PRINTER);
        System.out.println("Printer found : "+service.getName());
        FileInputStream in = null;

        try{
            in = new FileInputStream(file);//new File(INPUT+"template_palette.docx"));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(nbcopies));

        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(in,flavor,null);

        DocPrintJob job = service.createPrintJob();
        PrintJobWatcher pjw = new PrintJobWatcher(job);

        try{
            job.print(doc,pras);
        } catch (PrintException pe){
            pe.printStackTrace();
        }

        pjw.waitForDone();

        try{
            in.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        InputStream ff = new ByteArrayInputStream("\f".getBytes());
        Doc docff = new SimpleDoc(ff,flavor,null);
        DocPrintJob jobff = service.createPrintJob();
        pjw = new PrintJobWatcher(jobff);
        try {
            jobff.print(docff, null);
        } catch (PrintException pe){
            pe.printStackTrace();
        }
        pjw.waitForDone();
    }

}
