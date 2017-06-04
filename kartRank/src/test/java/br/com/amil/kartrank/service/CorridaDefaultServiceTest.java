package br.com.amil.kartrank.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.service.contract.VoltaService;
import br.com.amil.kartrank.util.GeralServiceTesteUtil;

public class CorridaDefaultServiceTest {
	private PilotoService pilotoService;
	private PilotoVoltaService pilotoVoltaService;
	private VoltaService voltaService;
	private GeralServiceTesteUtil geralServiceTesteUtil;
	
	public CorridaDefaultServiceTest(){
		pilotoService = new PilotoDefaultService();
		pilotoVoltaService = new PilotoVoltaDefaultService();
		voltaService = new VoltaDefaultService();
		geralServiceTesteUtil = new GeralServiceTesteUtil();
	}
	
	
	
	@Test
	public void indicadoresGeral(){
		geralServiceTesteUtil.inserirDadosBase();
		pilotoService.ordernarPilotosPorTempoFinal();
		
		PilotoPO pilotoFiltro = new PilotoPO();
		pilotoFiltro.setCodigo("038");
		pilotoFiltro.setNome("F.MASSA");
		
		PilotoPO piloto = pilotoService.buscarPilotoPorChave(pilotoFiltro);
		
		Assert.assertEquals(pilotoFiltro, piloto);
		Assert.assertEquals(2, piloto.getQuantidadeVoltas());
		Assert.assertEquals("00:02:05.703", piloto.getStTempoTotal());		
		
	}
	
	@After
	public void limparBase(){
		pilotoVoltaService.limparBase();
		pilotoService.limparBase();
		voltaService.limparBase();
	}


}
