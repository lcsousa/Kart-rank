package br.com.amil.kartrank.service;

import java.util.List;

import br.com.amil.kartrank.enums.CampoArquivoEnum;
import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.repository.PilotoVoltaMemoryRepository;
import br.com.amil.kartrank.repository.contract.PilotoVoltaRepository;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.util.GeralUtil;

/**
 * Classe responsável pela regras de negócio referentes a PilotoVoltaPO
 * @author LUIS CARDOSO
 *
 */
public class PilotoVoltaDefaultService implements PilotoVoltaService {
	private PilotoVoltaRepository pilotoVoltaRepository;
	
	public PilotoVoltaDefaultService(){
		pilotoVoltaRepository = new PilotoVoltaMemoryRepository();
	}	
	
	@Override
	public void adicionar(PilotoVoltaPO pilotoVolta){
		pilotoVoltaRepository.adicionar(pilotoVolta);
	}	
	
	@Override
	public PilotoVoltaPO salvar(PilotoVoltaPO pilotoVolta){
		adicionar(pilotoVolta);
		return pilotoVolta;
	}	
	
	@Override
	public void associarObjetos(PilotoVoltaPO pilotoVolta,VoltaPO volta,PilotoPO piloto){
		pilotoVolta.setPiloto(piloto);
		pilotoVolta.setVolta(volta);
	}	
	
	@Override
	public PilotoVoltaPO criarPilotoVolta(String linha){
		PilotoVoltaPO pilotoVolta = new PilotoVoltaPO();
	
		pilotoVolta.setHora(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.HORA));
		pilotoVolta.setTempo(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.TEMPO_VOLTA));

		pilotoVolta.setVelocidadeMedia(Double.valueOf(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.VELOCIDADE_MEDIA).replaceAll(",", ".")));
		return pilotoVolta;
	}
		
	@Override
	public List<PilotoVoltaPO> buscarTodos(){
		return pilotoVoltaRepository.buscarTodos();
	}
	
	
	@Override
	public PilotoVoltaPO getMelhorVoltaCorrida(){
		PilotoVoltaPO pilotoVoltaRetorno = null;
		List<PilotoVoltaPO> listaPilotoVolta = buscarTodos();
		for(PilotoVoltaPO pilotoVolta : listaPilotoVolta){
			if((pilotoVoltaRetorno == null) || (pilotoVolta.getTempoVoltaInteiro() < pilotoVoltaRetorno.getTempoVoltaInteiro())){
				pilotoVoltaRetorno = pilotoVolta;
			}			
		}		
		return pilotoVoltaRetorno;		
	}		
	
	@Override
	public PilotoVoltaPO buscarPorChave(PilotoVoltaPO chave){
		return pilotoVoltaRepository.buscarPorChave(chave);
	}

	@Override
	public void limparBase() {
		pilotoVoltaRepository.limparBase();		
	}

}
