package br.com.amil.kartrank.repository.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoVoltaPO;

/**
 * Classe responsável por armazenamento em memória de registros de PilotoVoltaPO, assim como métodos referentes a sua persistência
 * @author LUIS CARDOSO
 *
 */

public interface PilotoVoltaRepository {
	/**
	 * Persiste o PilotoVoltaPO
	 * @param piloto PilotoVoltaPO a ser persistido
	 */
	void adicionar(PilotoVoltaPO pilotoVolta);


	/**
	 * Lista todos PilotoVoltaPO persistido
	 * @return lista de PilotoVoltaPO
	 */
	List<PilotoVoltaPO> buscarTodos();
	
	/**
	 * Busca o PilotoVoltaPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o PilotoPO encontrado, se não encontrar retorna null
	 */
	PilotoVoltaPO buscarPorChave(PilotoVoltaPO chave);
	
	/**
	 * Limpa a base para testes unitários
	 */
	void limparBase();

}