package br.com.amil.kartrank.repository.contract;

import java.util.List;

import br.com.amil.kartrank.po.VoltaPO;
/**
 * Interface que define os m�todos (persist�ncia) referente a entidade VoltaPO
 * @author LUIS CARDOSO
 * 
 */
public interface VoltaRepository {

	/**
	 * Verifica se o VoltaPO j� existe persistido
	 * @param chave  filtro de entrada
	 * @return retorna true caso o VoltaPO j� tenha sido persistido e false em caso contr�rio
	 */
	boolean existe(VoltaPO chave);

	/**
	 * Persiste o VoltaPO
	 * @param piloto VoltaPO a ser persistido
	 */
	void adicionar(VoltaPO volta);

	/**
	 * Busca o VoltaPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o VoltaPO encontrado, se n�o encontrar retorna null
	 */
	VoltaPO buscarPorChave(VoltaPO chave);
	
	/**
	 * Lista todos VoltaPO persistido
	 * @return retorn lista de VoltaPO
	 */
	List<VoltaPO> buscarTodos();
	
	/**
	 * Limpa a base para testes unit�rios
	 */
	void limparBase();

}