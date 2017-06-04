package br.com.amil.kartrank.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.service.contract.VoltaService;

public class VoltaDefaultServiceTest {
	private VoltaService voltaService;
	
	public VoltaDefaultServiceTest(){
		voltaService = new VoltaDefaultService();
	}
	
	@Test
	public void adicionar(){
		VoltaPO volta = new VoltaPO();
		volta.setNumero(1);
		voltaService.adicionar(volta);
		
		VoltaPO voltaPersist = voltaService.buscarPorChave(volta);
		
		Assert.assertEquals(volta, voltaPersist);
	}
	
	@Test
	public void salvar(){
		VoltaPO voltaA = new VoltaPO();
		voltaA.setNumero(1);
		voltaService.salvar(voltaA);
		
		VoltaPO voltaB = new VoltaPO();
		voltaB.setNumero(1);
		voltaService.salvar(voltaB);
		
		VoltaPO voltaC = new VoltaPO();
		voltaC.setNumero(2);
		voltaService.salvar(voltaC);
		
		List<VoltaPO> listaVolta = voltaService.buscarTodos();
		VoltaPO voltaRetornoFiltro = voltaService.buscarPorChave(voltaC);		
		
		Assert.assertEquals(2, listaVolta.size());
		Assert.assertEquals(voltaC, voltaRetornoFiltro);	
	}
	
	@Test
	public void existe(){
		VoltaPO volta = new VoltaPO();
		volta.setNumero(1);
		voltaService.salvar(volta);
		
		VoltaPO voltaFiltro = new VoltaPO();
		voltaFiltro.setNumero(1);
		boolean existe = voltaService.existe(voltaFiltro);
		
		Assert.assertEquals(true, existe);
	}
	
	@Test
	public void criarVoltaEntrada(){
		String linha = "23:49:08.277      038 – F.MASSA             1     1:02.852            44,275";
		VoltaPO voltaEntrada = voltaService.criarVoltaEntrada(linha);
		
		VoltaPO volta = new VoltaPO();
		volta.setNumero(1);
		Assert.assertEquals(volta, voltaEntrada);
	}
	
	@After
	public void limparBase(){
		voltaService.limparBase();
	}	

}
