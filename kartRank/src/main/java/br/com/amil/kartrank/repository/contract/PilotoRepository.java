package br.com.amil.kartrank.repository.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoPO;

/**
 * Interface que define os m�todos (persist�ncia) referente a entidade PilotoPO
 * @author LUIS CARDOSO
 * 
 */
public interface PilotoRepository {
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
	PilotoPO buscarPorChave(PilotoPO chave);

	/**
	 * Lista todos PilotoPO persistido
	 * @return retorn lista de PilotoPO
	 */
	List<PilotoPO> buscarTodos();
	
	/**
	 * Limpa a base para testes unit�rios
	 */
	void limparBase();

}