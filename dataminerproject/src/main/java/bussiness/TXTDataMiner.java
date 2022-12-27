package bussiness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTDataMiner extends DataMiner {

	@Override
	public File openFile(String path) throws FileNotFoundException {
		File file = new File(path);
		return file;
	}

	@Override
	public String extractData(File file) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String texto = "";
		String linha = "";
		while (true) {
			if (linha != null) {
				texto += linha + "\n";
			} else
				break;
			linha = br.readLine();
		}
		closeFile(br);
		return texto;
	}
	
	public void closeFile(BufferedReader file) throws IOException {
		file.close();
	}
}
