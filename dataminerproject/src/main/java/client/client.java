package client;

import bussiness.DataMiner;
import bussiness.PDFDataMiner;
import bussiness.TXTDataMiner;

public class client {

	public static void main(String[] args) {
		
		DataMiner txt = new PDFDataMiner();
		txt.mine ("C:\\Users\\yvesl\\Downloads\\Boletim COVID-19 SE 47 2022.pdf");
		
		// INSIRA SUA URL ABSOLUTA
		//DataMiner txt = new TXTDataMiner();
		//txt.mine("C:\\Users\\yvesl\\Downloads\\Boletim-COVID-19-SE-47-2022.txt");
	}
}
