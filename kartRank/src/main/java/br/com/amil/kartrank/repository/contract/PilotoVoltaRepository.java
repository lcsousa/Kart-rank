package br.com.amil.kartrank.repository.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoVoltaPO;

/**
 * Classe respons�vel por armazenamento em mem�ria de registros de PilotoVoltaPO, assim como m�todos referentes a sua persist�ncia
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
	 * @return retorna o PilotoPO encontrado, se n�o encontrar retorna null
	 */
	PilotoVoltaPO buscarPorChave(PilotoVoltaPO chave);
	
	/**
	 * Limpa a base para testes unit�rios
	 */
	void limparBase();

}