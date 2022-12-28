package bussiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFDataMiner extends DataMiner{
	
	@Override
	public File openFile(String path) throws FileNotFoundException {
		File file = new File(path);
		return file;
	}

	@Override
	public String extractData(File file) throws IOException {
		PDDocument pdfDocument = null;
		
		pdfDocument = PDDocument.load(file);
		PDFTextStripper stripper = new PDFTextStripper();
		String texto = stripper.getText(pdfDocument);
		
		closeFile(pdfDocument);
		return texto;
	}
	
	public void closeFile(PDDocument file) throws IOException {
		file.close();
	}
}
