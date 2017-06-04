package br.com.amil.kartrank.service.contract;

import java.util.List;

import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;

public interface VoltaService {
	
	/**
	 * Verifica se o VoltaPO já existe persistido
	 * @param chave  filtro de entrada
	 * @return retorna true caso o VoltaPO já tenha sido persistido e false em caso contrário
	 */
	boolean existe(VoltaPO chave);

	
	/**
	 * Persiste o VoltaPO
	 * @param volta  Objeto a ser persistido
	 */
	void adicionar(VoltaPO volta);
	
	/**
	 * Busca o VoltaPO pela chave
	 * @param chave filtro de entrada
	 * @return retorna o VoltaPO encontrado, se não encontrar retorna null
	 */
	VoltaPO buscarPorChave(VoltaPO chave);
	
	/**
	 * Persiste o VoltaPO caso ainda não esteja persistido
	 * @param volta
	 * @return VoltaPO persistido
	 */
	VoltaPO salvar(VoltaPO volta);

	/**
	 * Cria um objeto VoltaPO a partir da linha de um arquivo
	 * @param linha  Representa a linha do arquivo
	 * @return  objeto VoltaPO criado
	 */
	VoltaPO criarVoltaEntrada(String linha);

	/**
	 * Associa o VoltaPO a seus indicadores (PilotoVoltaPO)
	 * @param volta VoltaPO completada
	 * @param pilotoVolta indicadores da volta que o PilotoPO acabou de realizar
	 */
	void associarObjetos(VoltaPO volta, PilotoVoltaPO pilotoVolta);
	

	/**
	 * Lista todos VoltaPO persistido
	 * @return retorn lista de VoltaPO
	 */
	List<VoltaPO> buscarTodos();
	
	/**
	 * Limpa a base para testes unitários
	 */
	void limparBase();

}