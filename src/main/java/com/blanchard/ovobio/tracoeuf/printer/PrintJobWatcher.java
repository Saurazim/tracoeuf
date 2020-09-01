package com.blanchard.ovobio.tracoeuf.printer;

import javax.print.DocPrintJob;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class PrintJobWatcher {
    boolean done = false;

    PrintJobWatcher(DocPrintJob job){
        job.addPrintJobListener(new PrintJobAdapter() {
            @Override
            public void printJobCompleted(PrintJobEvent pje) {
                allDone();
                System.out.println("Completed");
            }

            @Override
            public void printJobFailed(PrintJobEvent pje) {
                allDone();
                System.out.println("Failed");
            }

            @Override
            public void printJobCanceled(PrintJobEvent pje) {
                allDone();
                System.out.println("Canceled");
            }

            @Override
            public void printJobNoMoreEvents(PrintJobEvent pje) {
                allDone();
                System.out.println("No more events");
            }
        }
    );}

    private void allDone(){
        synchronized (PrintJobWatcher.this){
            done = true;
            System.out.println("Printing done");
            PrintJobWatcher.this.notify();
        }
    }

    public synchronized void waitForDone(){
        try{
            while (!done){
                wait();
            }
        } catch (InterruptedException ignored){}
    }
}
