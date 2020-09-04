package com.blanchard.ovobio.tracoeuf.printer;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.*;

public class Printer {
    private static final String INPUT = ConstantesUtil.getProperty(ConstExt.INPUT_PATH);
    private static final String OUTPUT = ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH);
    private static final String PRINTER = ConstantesUtil.getProperty(ConstExt.PRINTER_NAME);

    public void imprimer(File file, int nombreCopie) {
        PrintService service = PrintUtil.findPrintService(PRINTER);
        System.out.println("Printer found : "+service.getName());
        InputStream in = null;

        try{
            in = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(in,flavor,null);



        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(nombreCopie));

        DocPrintJob job = service.createPrintJob();
        PrintJobWatcher pjw = new PrintJobWatcher(job);


        InputStream ff = new ByteArrayInputStream("\f\f".getBytes());
        Doc docff = new SimpleDoc(ff,flavor,null);
        DocPrintJob jobff = service.createPrintJob();
        PrintJobWatcher pjwff = new PrintJobWatcher(jobff);

        //for (int i=1;1<nombreCopie;++i ){
            try {
                job.print(doc, pras);
            } catch (PrintException pe) {
                pe.printStackTrace();
                //break;
            }

            pjw.waitForDone();

            try {
                jobff.print(docff, null);
            } catch (PrintException pe) {
                pe.printStackTrace();
                //break;
            }
            pjwff.waitForDone();
        //}

        try{
            in.close();
            ff.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
