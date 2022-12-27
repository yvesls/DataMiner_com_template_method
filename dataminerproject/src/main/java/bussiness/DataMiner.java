package bussiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DataMiner {
	
	/**
	 * Template method
	 */
	public void mine(String path) {
		File file;
		try {
			file = openFile(path);
			String data = extractData(file);
			ArrayList<Object> busca = parseData(data);
			sendReport(busca);
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

	public ArrayList<Object> parseData(String data) {
		ArrayList<Object> busca = new ArrayList<Object>();
		busca.add("SEMANA EPIDEMIOLÓGICA - 2022");
		busca.add(data.indexOf(String.valueOf(busca.get(0))));
		return busca;
	}

	public void sendReport(ArrayList<Object> busca) {
		if(!busca.get(1).equals(-1)) {
			System.out.println(busca.get(1));
		}else {
			System.out.println("Dado não encontrado.");
		}
	}
}
