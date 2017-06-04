package br.com.amil.kartrank.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.repository.contract.PilotoVoltaRepository;

public class PilotoVoltaMemoryRepository implements PilotoVoltaRepository {

	private static List<PilotoVoltaPO> listaPilotoVolta = new ArrayList<PilotoVoltaPO>();
	
	@Override
	public void adicionar(PilotoVoltaPO pilotoVolta){
		listaPilotoVolta.add(pilotoVolta);
	}
	
	@Override
	public List<PilotoVoltaPO> buscarTodos(){
		return listaPilotoVolta;
	}
	
	@Override
	public PilotoVoltaPO buscarPorChave(PilotoVoltaPO chave){
		return listaPilotoVolta.stream().filter(piloto -> piloto.equals(chave)).findAny().orElse(null);
	}

	@Override
	public void limparBase() {
		listaPilotoVolta = new ArrayList<PilotoVoltaPO>();
		
	}
	
}
