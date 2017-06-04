package br.com.amil.kartrank.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.service.contract.VoltaService;
import br.com.amil.kartrank.util.GeralServiceTesteUtil;

public class PilotoDefaultServiceTest {
	private PilotoService pilotoService;
	private PilotoVoltaService pilotoVoltaService;
	private VoltaService voltaService;
	private GeralServiceTesteUtil geralServiceTesteUtil;
	
	public PilotoDefaultServiceTest(){
		pilotoService = new PilotoDefaultService();
		pilotoVoltaService = new PilotoVoltaDefaultService();
		voltaService = new VoltaDefaultService();
		geralServiceTesteUtil = new GeralServiceTesteUtil();
	}
	
	
	
	@Test
	public void salvar(){
		geralServiceTesteUtil.inserirDadosBase();
		
		PilotoPO pilotoC = new PilotoPO();
		pilotoC.setCodigo("033");
		pilotoC.setNome("R.BARRICHELLO");
		
		List<PilotoPO> listaPiloto = pilotoService.buscarTodos();
		PilotoPO pilotoRetornoFiltro = pilotoService.buscarPorChave(pilotoC);		
		
		Assert.assertEquals(2, listaPiloto.size());
		Assert.assertEquals(pilotoC, pilotoRetornoFiltro);				
	}
	
	@Test
	public void existe(){
		geralServiceTesteUtil.inserirDadosBase();
		PilotoPO pilotoA = new PilotoPO();
		pilotoA.setCodigo("038");
		pilotoA.setNome("F.MASSA");

		boolean existe = pilotoService.existe(pilotoA);
		
		Assert.assertEquals(true, existe);
	}
	
	@Test
	public void criarPilotoEntrada(){
		String linha = "23:49:08.277      038 – F.MASSA             1     1:02.852            44,275";
		PilotoPO pilotoEntrada = pilotoService.criarPilotoEntrada(linha);
		
		PilotoPO piloto = new PilotoPO();
		piloto.setCodigo("038");
		piloto.setNome("F.MASSA");
		
		Assert.assertEquals(piloto,pilotoEntrada);
	}
	
	@Test
	public void getVelocidadeMedia() {
		geralServiceTesteUtil.inserirDadosBase();
		PilotoPO piloto = new PilotoPO();
		piloto.setCodigo("038");
		piloto.setNome("F.MASSA");
		piloto = pilotoService.buscarPorChave(piloto);
		String stVelocidadeMedia = pilotoService.getVelocidadeMedia(piloto);
		
		Assert.assertEquals("60,00",stVelocidadeMedia);
	}
	
	@Test
	public void getMelhorVoltaPorPiloto(){
		geralServiceTesteUtil.inserirDadosBase();
		PilotoPO piloto = new PilotoPO();
		piloto.setCodigo("038");
		piloto.setNome("F.MASS");
		
		PilotoPO pilotoFiltro = pilotoService.buscarPorChave(piloto);
		PilotoVoltaPO melhorVolta = pilotoService.getMelhorVoltaPorPiloto(pilotoFiltro);
		
		Assert.assertEquals("1:02.851", melhorVolta.getTempo());			
	}		
	
	@After
	public void limparBase(){
		pilotoVoltaService.limparBase();
		pilotoService.limparBase();
		voltaService.limparBase();
	}

}
