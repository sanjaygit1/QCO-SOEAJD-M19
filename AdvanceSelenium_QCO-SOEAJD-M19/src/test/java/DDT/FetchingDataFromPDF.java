package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {

File fis = new File("./src/test/resources/multipage-pdf.pdf");

	PDDocument doc  = PDDocument.load(fis);
	
	int pages = doc.getNumberOfPages();//prints num of pages
	System.out.println(pages);
	
	PDFTextStripper pdfData = new PDFTextStripper();
//	String readDoc = pdfData.getText(doc);
//	System.out.println(readDoc);
	
//	pdfData.setStartPage(5);
//	String readDoc = pdfData.getText(doc);
//	System.out.println(readDoc);
	
	pdfData.setStartPage(2);
	pdfData.setEndPage(2);
	String readDoc = pdfData.getText(doc);
	System.out.println(readDoc);
	
	
	
	
	}

}
