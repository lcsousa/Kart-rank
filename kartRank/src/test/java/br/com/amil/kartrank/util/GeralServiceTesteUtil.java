package br.com.amil.kartrank.util;

import br.com.amil.kartrank.po.PilotoPO;
import br.com.amil.kartrank.po.PilotoVoltaPO;
import br.com.amil.kartrank.po.VoltaPO;
import br.com.amil.kartrank.service.PilotoDefaultService;
import br.com.amil.kartrank.service.PilotoVoltaDefaultService;
import br.com.amil.kartrank.service.VoltaDefaultService;
import br.com.amil.kartrank.service.contract.PilotoService;
import br.com.amil.kartrank.service.contract.PilotoVoltaService;
import br.com.amil.kartrank.service.contract.VoltaService;

public class GeralServiceTesteUtil {
	
	private PilotoService pilotoService;
	private PilotoVoltaService pilotoVoltaService;
	private VoltaService voltaService;
	
	public GeralServiceTesteUtil(){
		pilotoService = new PilotoDefaultService();
		pilotoVoltaService = new PilotoVoltaDefaultService();
		voltaService = new VoltaDefaultService();
	}

	public void inserirDadosBase(){		
		
		PilotoVoltaPO pilotoVoltaA = new PilotoVoltaPO();
		pilotoVoltaA.setTempo("1:02.852");
		pilotoVoltaA.setVelocidadeMedia(70.0);
		PilotoPO pilotoA = new PilotoPO();
		pilotoA.setCodigo("038");
		pilotoA.setNome("F.MASSA");
		VoltaPO voltaA = new VoltaPO();
		voltaA.setNumero(1);
		pilotoService.salvar(pilotoA);
		voltaService.salvar(voltaA);
		pilotoVoltaService.salvar(pilotoVoltaA);
		pilotoVoltaService.associarObjetos(pilotoVoltaA, voltaA, pilotoA);
		pilotoService.associarObjetos(pilotoA, pilotoVoltaA);
		voltaService.associarObjetos(voltaA, pilotoVoltaA);
		
		
		PilotoVoltaPO pilotoVoltaB = new PilotoVoltaPO();
		PilotoPO pilotoB = new PilotoPO();
		pilotoVoltaB.setTempo("1:02.851");
		pilotoVoltaB.setVelocidadeMedia(50.0);
		pilotoB.setCodigo("038");
		pilotoB.setNome("F.MASS");
		VoltaPO voltaB = new VoltaPO();
		voltaB.setNumero(2);
		pilotoB = pilotoService.salvar(pilotoB);
		pilotoVoltaB = pilotoVoltaService.salvar(pilotoVoltaB);		
		voltaB = voltaService.salvar(voltaB);
		pilotoVoltaService.associarObjetos(pilotoVoltaB, voltaB, pilotoB);
		pilotoService.associarObjetos(pilotoB, pilotoVoltaB);
		voltaService.associarObjetos(voltaB, pilotoVoltaB);
		
		
		PilotoVoltaPO pilotoVoltaC = new PilotoVoltaPO();
		PilotoPO pilotoC = new PilotoPO();
		pilotoVoltaC.setTempo("1:02.850");
		pilotoC.setCodigo("033");
		pilotoC.setNome("R.BARRICHELLO");
		VoltaPO voltaC = new VoltaPO();
		voltaC.setNumero(1);
		pilotoC = pilotoService.salvar(pilotoC);
		pilotoVoltaC = pilotoVoltaService.salvar(pilotoVoltaC);		
		voltaC = voltaService.salvar(voltaC);
		pilotoVoltaService.associarObjetos(pilotoVoltaC, voltaC, pilotoC);
		pilotoService.associarObjetos(pilotoC, pilotoVoltaC);
		voltaService.associarObjetos(voltaC, pilotoVoltaC);
		
		
	}
}
