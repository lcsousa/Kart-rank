package br.com.amil.kartrank.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.service.contract.VoltaService;
import br.com.amil.kartrank.util.GeralServiceTesteUtil;

public class PilotoVoltaDefaultServiceTest {
	private PilotoService pilotoService;
	private PilotoVoltaService pilotoVoltaService;
	private VoltaService voltaService;
	private GeralServiceTesteUtil geralServiceTesteUtil;
	
	public PilotoVoltaDefaultServiceTest(){
		pilotoService = new PilotoDefaultService();
		pilotoVoltaService = new PilotoVoltaDefaultService();
		voltaService = new VoltaDefaultService();
		geralServiceTesteUtil = new GeralServiceTesteUtil();
	}
	
	
	@Test
	public void salvar(){
		geralServiceTesteUtil.inserirDadosBase();
		PilotoVoltaPO pilotoVoltaFiltro = new PilotoVoltaPO();
		PilotoPO piloto = new PilotoPO();
		piloto.setCodigo("033");
		piloto.setNome("R.BARRICHELLO");
		VoltaPO volta = new VoltaPO();
		volta.setNumero(1);
		pilotoVoltaService.associarObjetos(pilotoVoltaFiltro, volta, piloto);
		pilotoService.associarObjetos(piloto, pilotoVoltaFiltro);
		voltaService.associarObjetos(volta, pilotoVoltaFiltro);
		List<PilotoVoltaPO> listaPiloto = pilotoVoltaService.buscarTodos();
		PilotoVoltaPO pilotoRetornoFiltro = pilotoVoltaService.buscarPorChave(pilotoVoltaFiltro);		
		
		Assert.assertEquals(3, listaPiloto.size());
		Assert.assertEquals(pilotoVoltaFiltro, pilotoRetornoFiltro);		
		
	}
	
	@Test
	public void getMelhorVoltaCorrida(){
		geralServiceTesteUtil.inserirDadosBase();
		PilotoVoltaPO melhorVolta = pilotoVoltaService.getMelhorVoltaCorrida();		
		Assert.assertEquals("1:02.850", melhorVolta.getTempo());			
	}
		
	@After
	public void limparBase(){
		pilotoVoltaService.limparBase();
		pilotoService.limparBase();
		voltaService.limparBase();
	}


}
