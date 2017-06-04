package br.com.amil.kartrank.service;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.kartrank.enums.CampoArquivoEnum;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.repository.VoltaMemoryRepository;
import br.com.amil.kartrank.repository.contract.VoltaRepository;
import br.com.amil.kartrank.service.contract.VoltaService;
import br.com.amil.kartrank.util.GeralUtil;

/**
 * Classe responsável pela regras de negócio referentes a VoltaPO
 * @author LUIS CARDOSO
 *
 */
public class VoltaDefaultService implements VoltaService {
	private VoltaRepository voltaRepository;
	
	public VoltaDefaultService(){
		voltaRepository = new VoltaMemoryRepository();
	}
	
	@Override
	public boolean existe(VoltaPO chave){
		return voltaRepository.existe(chave);
	}
	
	@Override
	public void adicionar(VoltaPO volta){
		voltaRepository.adicionar(volta);
	}
	
	@Override
	public VoltaPO buscarPorChave(VoltaPO chave){
		return voltaRepository.buscarPorChave(chave);
	}
	
	@Override
	public  VoltaPO salvar(VoltaPO volta){
		if(!existe(volta)){				
			adicionar(volta);
		}else{
			volta = voltaRepository.buscarPorChave(volta);
		}
		return volta;
	}
	
	@Override
	public VoltaPO criarVoltaEntrada(String linha){
		VoltaPO volta = new VoltaPO();
		volta.setNumero(Integer.valueOf(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.NUMERO_VOLTA)));
		return volta;
	}
	
	@Override
	public void associarObjetos(VoltaPO volta,PilotoVoltaPO pilotoVolta){
		if(volta.getListaPilotoVolta() == null){
			volta.setListaPilotoVolta(new ArrayList<PilotoVoltaPO>());
		}
		volta.getListaPilotoVolta().add(pilotoVolta);		
	}

	@Override
	public List<VoltaPO> buscarTodos() {
		// TODO Auto-generated method stub
		return voltaRepository.buscarTodos();
	}

	@Override
	public void limparBase() {
		voltaRepository.limparBase();		
	}
}
