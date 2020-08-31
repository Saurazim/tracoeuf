package com.blanchard.ovobio.tracoeuf.printer;

import javax.print.PrintService;
import javax.print.attribute.standard.PrinterName;
import java.awt.print.PrinterJob;
import java.util.Iterator;

public interface PrintUtil {
    public static PrintService findPrintService(String printerName){
        printerName = printerName.toLowerCase();

        PrintService service = null;

        PrintService[] services = PrinterJob.lookupPrintServices();

        for (PrintService s : services){
            if (printerName.equals(s.getName().toLowerCase()))
                service = s;
            System.out.println("service : "+s.getName());
        }

        return service;
    }
}
