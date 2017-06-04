package br.com.amil.kartrank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.amil.kartrank.enums.CampoArquivoEnum;
import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.repository.PilotoMemoryRepository;
import br.com.amil.kartrank.repository.contract.PilotoRepository;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.util.ConstantesUtil;
import br.com.amil.kartrank.util.DateUtil;
import br.com.amil.kartrank.util.GeralUtil;

/**
 * Classe responsável pela regras de negócio referentes a PilotoPO
 * @author LUIS CARDOSO
 *
 */
public class PilotoDefaultService implements PilotoService {
	
	private PilotoRepository pilotoRepository;
	
	public PilotoDefaultService(){
		pilotoRepository = new PilotoMemoryRepository();
	}
	
	@Override
	public PilotoPO buscarPorChave(PilotoPO chave){
		return pilotoRepository.buscarPorChave(chave);
	}
	@Override
	public  PilotoPO criarPilotoEntrada(String linha){
		
		PilotoPO piloto = new PilotoPO();
		piloto.setCodigo(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.PILOTO_CODIGO));
		piloto.setNome(GeralUtil.getSubStringTrim(linha, CampoArquivoEnum.PILOTO_NOME));
		return piloto;
	}
	
	/**
	 * Identifica a última volta realizada pelo piloto
	 * @param piloto piloto para identificação da última volta
	 * @return número da volta
	 */
	private Integer getMaiorVolta(PilotoPO piloto){
		Integer maiorVolta = -1;
		for (PilotoVoltaPO pilotoVolta : piloto.getListaPilotoVolta()) {
			if (pilotoVolta.getVolta().getNumero() > maiorVolta) {
				maiorVolta = pilotoVolta.getVolta().getNumero();
			}
		}
		return maiorVolta;
	}
	
	/**
	 * calcula o horário de chegada do piloto
	 * @param piloto piloto para cálculo do horário de chegada
	 * @return horario de chegada em nanosegundos
	 */
	private Long getHorarioChegada(PilotoPO piloto) {
		long horario = -1;
		for (PilotoVoltaPO pilotoVolta : piloto.getListaPilotoVolta()) {
			if (pilotoVolta.getVolta().getNumero().equals(ConstantesUtil.QUANTIDADE_VOLTAS)) {
				horario = pilotoVolta.getHorarioVoltaInteiro();
			}
		}
		return horario;

	}

	
	@Override
	public String getTempoChegadaPosCampeao(PilotoPO piloto) {
		 PilotoPO pilotoCampeao = buscarTodos().get(0);
		long horario = getHorarioChegada(piloto);
		if(horario == -1){
			return "NÃO COMPLETOU A PROVA";
		}
		long horarioCampeao = getHorarioChegada(pilotoCampeao);		
		long horarioPoscampeao = horario - horarioCampeao;
		return DateUtil.converterInteiroEmEmHorario(horarioPoscampeao);

	}
	
	@Override
	public PilotoVoltaPO getMelhorVoltaPorPiloto(PilotoPO piloto) {
		PilotoVoltaPO pilotoVoltaretorno = null;
		
		for(PilotoVoltaPO pilotoVolta:piloto.getListaPilotoVolta()){
			if((pilotoVoltaretorno == null) || (pilotoVolta.getTempoVoltaInteiro() < pilotoVoltaretorno.getTempoVoltaInteiro())){
				pilotoVoltaretorno = pilotoVolta;
				continue;
			}
		}
		
		return pilotoVoltaretorno;
	}
	
	
	@Override
	public String getVelocidadeMedia(PilotoPO piloto) {
		BigDecimal velocidadeMedia = BigDecimal.ZERO;
		
		for(PilotoVoltaPO pilotoVolta:piloto.getListaPilotoVolta()){
			velocidadeMedia = velocidadeMedia.add(new BigDecimal(pilotoVolta.getVelocidadeMedia()));		
		}
		
		if (velocidadeMedia.compareTo(BigDecimal.ZERO) > 0) {
			return velocidadeMedia.divide(new BigDecimal(piloto.getListaPilotoVolta().size()), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).toString().replaceAll("\\.", ",");
		}
		
		return "";
	}	
	
	@Override
	public boolean existe(PilotoPO chave){
		return pilotoRepository.existe(chave);
	}
	
	
	@Override
	public  void adicionar(PilotoPO piloto){
		pilotoRepository.adicionar(piloto);
	}
	
	
	@Override
	public  PilotoPO buscarPilotoPorChave(PilotoPO chave){
		return pilotoRepository.buscarPorChave(chave);
	}
	
	@Override
	public  List<PilotoPO> buscarTodos(){
		return pilotoRepository.buscarTodos();
	}
	
	
	@Override
	public  PilotoPO salvar(PilotoPO piloto){
		if(!existe(piloto)){				
			adicionar(piloto);
		}else{
			piloto = pilotoRepository.buscarPorChave(piloto);
		}
		return piloto;
	}
	
	
	@Override
	public void associarObjetos(PilotoPO piloto,PilotoVoltaPO pilotoVolta){
		if(piloto.getListaPilotoVolta() == null){
			piloto.setListaPilotoVolta(new ArrayList<PilotoVoltaPO>());
		}

		piloto.getListaPilotoVolta().add(pilotoVolta);
		
	}
	
	@Override
	public void ordernarPilotosPorTempoFinal() {
		pilotoRepository.buscarTodos().sort(new Comparator<PilotoPO>() {
			@Override
			public int compare(PilotoPO o1, PilotoPO o2) {
				if(getMaiorVolta(o1).equals(getMaiorVolta(o2))){
					return getHorarioChegada(o1).compareTo(getHorarioChegada(o2));
				}else{
					return getMaiorVolta(o2).compareTo(getMaiorVolta(o1));
				}
				
			}
		});
	}

	@Override
	public void limparBase() {
		pilotoRepository.limparBase();
		
	}
	
}
