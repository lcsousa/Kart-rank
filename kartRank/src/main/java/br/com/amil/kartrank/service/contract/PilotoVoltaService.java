package br.com.amil.kartrank.service.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;

public interface PilotoVoltaService {
	/**
	 * Persiste o PilotoVoltaPO
	 * @param piloto PilotoVoltaPO a ser persistido
	 */
	void adicionar(PilotoVoltaPO pilotoVolta);

	/**
	 *  Persiste o PilotoVoltaPO caso ainda não esteja persistido
	 * @param pilotoVolta Objeto para ser persistido
	 * @return PilotoVoltaPO persistido
	 */
	PilotoVoltaPO salvar(PilotoVoltaPO pilotoVolta);
	
	/**
	 *  Associa o VoltaPO e PilotoPO ao PilotoVoltaPO
	 * @param pilotoVolta idicador do PilotPO e VoltaPO
	 * @param volta Volta competada
	 * @param piloto Piloto que completou a Volta
	 */
	void associarObjetos(PilotoVoltaPO pilotoVolta, VoltaPO volta, PilotoPO piloto);

	/**
	 *  Cria um objeto PilotoVoltaPO a partir da linha de um arquivo
	 * @param linha Representa a linha do arquivo
	 * @return PilotoVoltaPO criado
	 */
	PilotoVoltaPO criarPilotoVolta(String linha);

	/**
	 * Lista todos PilotoVoltaPO persistido
	 * @return lista de PilotoVoltaPO
	 */
	List<PilotoVoltaPO> buscarTodos();

	/**
	 * Identifica a melhor Volta da corrida
	 * @return indicadores (PilotoVoltaPO) da melhor volta da corrida
	 */
	PilotoVoltaPO getMelhorVoltaCorrida();

	
	
	/**
	 * Busca o PilotoPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o PilotoVoltaPO encontrado, se não encontrar retorna null
	 */
	PilotoVoltaPO buscarPorChave(PilotoVoltaPO chave);
	
	/**
	 * Limpa a base para testes unitários
	 */
	void limparBase();

}