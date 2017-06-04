package br.com.amil.kartrank.service.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;

public interface PilotoService {

	/**
	 * 
	 * @param linha  Representa a linha do arquivo
	 * @return reotrna objeto PilotoPO
	 */
	PilotoPO criarPilotoEntrada(String linha);

	/**
	 * Calcula o tempo de chegada do Piloto ap�s o campe�o
	 * @param piloto PilotoPO para c�lculo do tempo de chegada ap�s campe�o
	 * @return Tempo de chegada do piloto ap�s o campe�o
	 */
	String getTempoChegadaPosCampeao(PilotoPO piloto);

	/**
	 * Calcula velocidade m�dia do piloto na corrida
	 * @param piloto Piloto para c�lculo da velocidade m�dia
	 * @return Velocidade m�dia do piloto
	 */
	String getVelocidadeMedia(PilotoPO piloto);

	/**
	 * Verifica se o PilotoPO j� existe persistido
	 * @param chave  filtro de entrada
	 * @return retorna true caso o Piloto j� tenha sido persistido e false em caso contr�rio
	 */
	boolean existe(PilotoPO chave);

	/**
	 * Persiste o PilotoPO
	 * @param piloto Objeto a ser persistido
	 */
	void adicionar(PilotoPO piloto);

	/**
	 * Busca o PilotoPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o PilotoPO encontrado, se n�o encontrar retorna null
	 */
	PilotoPO buscarPilotoPorChave(PilotoPO chave);

	/**
	 * Lista todos PilotoPO persistido
	 * @return retorn lista de PilotoPO
	 */
	List<PilotoPO> buscarTodos();
	
	
	/**
	 * Persiste o PilotoPO caso ainda n�o esteja persistido
	 * @param piloto
	 * @return PilotoPO persistido
	 */
	PilotoPO salvar(PilotoPO piloto);

	/**
	 * Associa o PilotoPO a seus indicadores da volta (PilotoVoltaPO)
	 * @param piloto PilotoPO que completou a volta
	 * @param pilotoVolta indicadores da volta que o PilotoPO acabou de realizar
	 */
	void associarObjetos(PilotoPO piloto, PilotoVoltaPO pilotoVolta);

	/**
	 * Ordena os piloto de acordo com a classifica��o na corrida
	 */
	void ordernarPilotosPorTempoFinal();
	
	/**
	 * Busca o PilotoPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o PilotoPO encontrado, se n�o encontrar retorna null
	 */
	PilotoPO buscarPorChave(PilotoPO chave);
	
	/**
	 * Identifica a melhor volta do piloto
	 * @param piloto Piloto o qual deve identificar a melhor Volta
	 * @return indicadores (PilotoVoltaPO) da melhor volta do Piloto
	 */
	PilotoVoltaPO getMelhorVoltaPorPiloto(PilotoPO piloto);
	
	/**
	 * Limpa a base para testes unit�rios
	 */
	void limparBase();

}