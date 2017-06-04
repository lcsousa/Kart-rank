package br.com.amil.kartrank.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.repository.contract.VoltaRepository;

/**
 * Classe responsável por armazenamento em memório de registros de VoltaPO, assim como métodos referentes a sua persistência
 * @author LUIS CARDOSO
 *
 */
public class VoltaMemoryRepository implements VoltaRepository {

	private static List<VoltaPO> listaVoltas = new ArrayList<VoltaPO>();
	
	@Override
	public boolean existe(VoltaPO chave) {
		return listaVoltas.contains(chave);
	}

	@Override
	public void adicionar(VoltaPO volta) {
		listaVoltas.add(volta);
	}	
	
	@Override
	public VoltaPO buscarPorChave(VoltaPO chave) {
		return listaVoltas.stream().filter(volta -> volta.equals(chave)).findAny().orElse(null);
	}

	@Override
	public List<VoltaPO> buscarTodos() {
		return listaVoltas;
	}

	@Override
	public void limparBase() {
		listaVoltas = new ArrayList<VoltaPO>();
		
	}

}
