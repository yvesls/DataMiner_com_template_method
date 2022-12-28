package bussiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DataMiner {
	
	/**
	 * Template method
	 */
	public void mine(String path, String search) {
		File file;
		try {
			file = openFile(path);
			String data = extractData(file);
			int localization = parseData(data, search);
			sendReport(localization);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Abre arquivo do tipo File
	 * OBS: Escolhi deixá-lo na classe abstrata para evitar repetição
	 * OBS: Dado que, cada formato possui um tratamento diferente, cada arquivo possui um método para fechá-lo exclusivo
	 */
	protected abstract File openFile(String path) throws FileNotFoundException;
	
	protected abstract String extractData(File file) throws FileNotFoundException, IOException;
	
	/**
	 * Busca por uma sentença dentro do texto lido
	 * Retorna um array contendo a sentença e a localização 
	 */

	public int parseData(String data, String search) {
		return data.indexOf(search);
	}
	
	/**
	 * Exibe o resultado na forma de print
	 */
	public void sendReport(int Localization) {
		if(Localization != -1) {
			System.out.println("Localização dentro do texto: " + Localization);
		}else {
			System.out.println("Dado não encontrado.");
		}
	}
}
