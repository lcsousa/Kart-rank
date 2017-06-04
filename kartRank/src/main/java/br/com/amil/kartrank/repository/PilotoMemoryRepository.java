package br.com.amil.kartrank.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.repository.contract.PilotoRepository;

/**
 * Classe responsável por armazenamento em memória de registros de PilotoPO, assim como métodos referentes a sua persistência
 * @author LUIS CARDOSO
 *
 */
public class PilotoMemoryRepository implements PilotoRepository {

	private static List<PilotoPO> listaPiloto = new ArrayList<PilotoPO>();
		
	@Override
	public boolean existe(PilotoPO chave){
		return listaPiloto.contains(chave);
	}
		
	@Override
	public void adicionar(PilotoPO piloto){
		listaPiloto.add( piloto);
	}
		
	@Override
	public PilotoPO buscarPorChave(PilotoPO chave){
		return listaPiloto.stream().filter(piloto -> piloto.equals(chave)).findAny().orElse(null);
	}

	@Override
	public List<PilotoPO> buscarTodos(){
			return listaPiloto;
	}

	@Override
	public void limparBase() {
		listaPiloto = new ArrayList<PilotoPO>();
		
	}
		
}
