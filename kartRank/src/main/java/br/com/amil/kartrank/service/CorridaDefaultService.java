package br.com.amil.kartrank.service;

import java.util.List;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.service.contract.CorridaService;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.service.contract.VoltaService;
import br.com.amil.kartrank.util.FileUtil;

public class CorridaDefaultService implements CorridaService {
	
	private PilotoService pilotoService;
	private VoltaService voltaService;
	private PilotoVoltaService pilotoVoltaService;
	private String pathFileCorrida;
	
	public CorridaDefaultService(String pathFileCorrida) throws Exception{
		this();
		this.pathFileCorrida = pathFileCorrida;
		processarResultadoCorrida();
	}
	
	public CorridaDefaultService(){
		pilotoService = new PilotoDefaultService();
		voltaService = new VoltaDefaultService();
		pilotoVoltaService = new PilotoVoltaDefaultService();
	}
	
	
	@Override
	public void printResultado(){		
		printResultadoRanking();
		printResultadoBonus();
		
	}
	/**
	 * Imprime os indicadores de cada Piloto na corrida (Posição Chegada, Código Piloto,Nome Piloto,Qtde Voltas Completadas,Tempo Total de Prova)
	 */
	private void printResultadoRanking(){
		System.out.println("\n------------- CLASSIFICAÇÃO GERAL ------------- ");
		List<PilotoPO> listaPiloto = pilotoService.buscarTodos();
		for (int i = 0; i < listaPiloto.size(); i++) {
			PilotoPO piloto = listaPiloto.get(i);
			System.out.println(String.format("Posição Chegada: %d | Código Piloto: %s | Nome Piloto: %s | Qtde Voltas Completadas: %d | Tempo Total de Prova: %s", (i+1), piloto.getCodigo(), piloto.getNome(), piloto.getQuantidadeVoltas(), piloto.getStTempoTotal()));
		}		
	}
	
	/**
	 * Imprime os resultados dos item de bônus do exercício
	 */
	private void printResultadoBonus(){
		printVoltaMaisRapidaPorPiloto();
		printVelocidadeMediaPorPiloto();
		printVoltaMaisRapidaDaCorrida();
		printTempoChegadaAposCampeao();
		
	}
	
	/**
	 * Imprime a Volta Mais Rápida por Piloto
	 */
	private void printVoltaMaisRapidaPorPiloto(){
		System.out.println("\n------------- VOLTA MAIS RÁPIDA POR PILOTO ------------- ");
		List<PilotoPO> listaPiloto = pilotoService.buscarTodos();
		for (int i = 0; i < listaPiloto.size(); i++) {
			PilotoPO piloto = listaPiloto.get(i);
			PilotoVoltaPO pilotoVolta = pilotoService.getMelhorVoltaPorPiloto(piloto);
			System.out.println(String.format("Código Piloto: %s | Nome Piloto: %s | Volta Mais Rápida: %s | Tempo: %s", piloto.getCodigo(),piloto.getNome(), pilotoVolta.getVolta().getNumero(), pilotoVolta.getTempo()));
		}		
	}
	
	/**
	 * Imprime a Volta Mais Rápida da Corrida
	 */
	private void printVoltaMaisRapidaDaCorrida(){
		System.out.println("\n------------- VOLTA MAIS RÁPIDA DA CORRIDA ------------- ");
		PilotoVoltaPO pilotoVolta = pilotoVoltaService.getMelhorVoltaCorrida();
		System.out.println(String.format("Código Piloto: %s | Nome Piloto: %s | Volta Mais Rápida: %s | Tempo: %s", pilotoVolta.getPiloto().getCodigo(),pilotoVolta.getPiloto().getNome(), pilotoVolta.getVolta().getNumero(), pilotoVolta.getTempo()));		
	}
	
	/**
	 * Imprime a Velocidade média por Piloto
	 */
	private void printVelocidadeMediaPorPiloto(){
		System.out.println("\n------------- VELOCIDADE MÉDIA POR PILOTO ------------- ");
		List<PilotoPO> listaPiloto = pilotoService.buscarTodos();
		for (int i = 0; i < listaPiloto.size(); i++) {
			PilotoPO piloto = listaPiloto.get(i);			
			System.out.println(String.format("Código Piloto: %s | Nome Piloto: %s | Velocidade Média: %s", piloto.getCodigo(),piloto.getNome(), pilotoService.getVelocidadeMedia(piloto)));
		}		
	}
	
	/**
	 * Imprime o tempo de chegada de cada piloto após o campeão
	 */
	private void printTempoChegadaAposCampeao(){
		System.out.println("\n------------- TEMPO DE CHEGADA APÓS O CAMPEÃO ------------- ");
		List<PilotoPO> listaPiloto = pilotoService.buscarTodos();
		for (int i = 0; i < listaPiloto.size(); i++) {		
			PilotoPO piloto = listaPiloto.get(i);			
			System.out.println(String.format("Código Piloto: %s | Nome Piloto: %s | Tempo de Chegada após vencedor: %s", piloto.getCodigo(),piloto.getNome(), pilotoService.getTempoChegadaPosCampeao(piloto)));
		}		
	}
	
	/**
	 * Método que transforma informações do arquivo de log e persiste na estrutura de dados do persistence
	 * @throws Exception
	 */
	private  void carregarCorrida() throws Exception {
		
		List<String> listaLinha = FileUtil.getLinhas(pathFileCorrida);
		
		//remove cabeçalho
		listaLinha.remove(0);
		
		for(String linha:listaLinha){
			
			PilotoPO piloto = pilotoService.criarPilotoEntrada(linha);
			piloto = pilotoService.salvar(piloto);
			
			VoltaPO volta = voltaService.criarVoltaEntrada(linha);
			volta  = voltaService.salvar(volta);
			
			PilotoVoltaPO pilotoVolta = pilotoVoltaService.criarPilotoVolta(linha);
			pilotoVolta =  pilotoVoltaService.salvar(pilotoVolta);
			
			associarObjetos(pilotoVolta, volta, piloto);
			
		}		
		
	}
	

	/**
	 *  Associa o VoltaPO e PilotoPO ao PilotoVoltaPO
	 * @param pilotoVolta idicador do PilotPO e VoltaPO
	 * @param volta Volta competada
	 * @param piloto Piloto que completou a Volta
	 */
	private void associarObjetos(PilotoVoltaPO pilotoVolta,VoltaPO volta,PilotoPO piloto){
		pilotoVoltaService.associarObjetos(pilotoVolta, volta, piloto);
		pilotoService.associarObjetos(piloto, pilotoVolta);
		voltaService.associarObjetos(volta, pilotoVolta);
	}
	
	/**
	 * processa a corrida e ordena de acordo com a classificação
	 * @throws Exception
	 */
	private void processarResultadoCorrida() throws Exception{
		carregarCorrida();
		pilotoService.ordernarPilotosPorTempoFinal();
	}
	
}
