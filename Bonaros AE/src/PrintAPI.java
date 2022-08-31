import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class PrintAPI {
	
	private PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
	final byte[] VALIDATION_MODE = new byte[]{27, 'c', '0', 4}; // Print in validation mode
	final byte[]  PAPER_FULL_CUT = {0x1d,0x56,0x00}; // Full cut paper
	final byte[]  PAPER_PART_CUT = {0x1d,0x56,0x01}; // Partial cut paper

	public PrintAPI(String text) throws IOException {
		
		PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		
	    //InputStream is = new ByteArrayInputStream(text.getBytes("UTF8"));
	    PrintRequestAttributeSet  pras = new HashPrintRequestAttributeSet();
	    pras.add(new Copies(1));

	    DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
	    FileInputStream fin = new FileInputStream(text);
	    Doc doc = new SimpleDoc(fin, flavor, null);
	    DocPrintJob job = service.createPrintJob();

	    PrintJobWatcher pjw = new PrintJobWatcher(job);
	    try {
			job.print(doc, pras);
		} catch (PrintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   pjw.waitForDone();
	    fin.close();
	  }
	}
class PrintJobWatcher {
	
	  boolean done = false;

	  PrintJobWatcher(DocPrintJob job) {
	    job.addPrintJobListener(new PrintJobAdapter() {
	      public void printJobCanceled(PrintJobEvent pje) {
	        allDone();
	      }
	      public void printJobCompleted(PrintJobEvent pje) {
	        allDone();
	      }
	      public void printJobFailed(PrintJobEvent pje) {
	        allDone();
	        System.out.println("Failed");
	      }
	      public void printJobNoMoreEvents(PrintJobEvent pje) {
	        allDone();
	      }
	      void allDone() {
	        synchronized (PrintJobWatcher.this) {
	          done = true;
	          System.out.println("Printing document is done ...");
	          PrintJobWatcher.this.notify();
	        }
	      }
	    });
	  }
	
	
public synchronized void waitForDone() {
    try {
      while (!done) {
        wait();
      }
    } catch (InterruptedException e) {
    }
  }
}
