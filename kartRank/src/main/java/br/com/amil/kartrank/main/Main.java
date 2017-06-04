package br.com.amil.kartrank.main;

import br.com.amil.kartrank.service.CorridaDefaultService;
import br.com.amil.kartrank.service.contract.CorridaService;
import br.com.amil.kartrank.util.ConstantesUtil;


/**
 * Classe que possui o método main, ponto de partida do projeto.
 * @author LUIS CARDOSO
 *
 */ 
public class Main {
	public static void main(String[] args) {
		
		try {
			
			CorridaService corridaService = new CorridaDefaultService(ConstantesUtil.ARQUIVO_LOG);
			corridaService.printResultado();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
