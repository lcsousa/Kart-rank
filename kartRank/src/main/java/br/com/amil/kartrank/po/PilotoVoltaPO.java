package br.com.amil.kartrank.po;

import br.com.amil.kartrank.util.DateUtil;

public class PilotoVoltaPO {
	
	private PilotoPO piloto;
	private VoltaPO volta;
	private String hora;
	private String tempo;
	private Double velocidadeMedia;

	public PilotoVoltaPO() {
	}

	public VoltaPO getVolta() {
		return volta;
	}

	public void setVolta(VoltaPO volta) {
		this.volta = volta;
	}

	public PilotoPO getPiloto() {
		return piloto;
	}

	public void setPiloto(PilotoPO piloto) {
		this.piloto = piloto;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
	public long getTempoVoltaInteiro() {
		return DateUtil.converterHorarioEmInteiro(tempo);
	}

	public long getHorarioVoltaInteiro() {
		return DateUtil.converterHorarioEmInteiro(hora);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
		result = prime * result + ((volta == null) ? 0 : volta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PilotoVoltaPO other = (PilotoVoltaPO) obj;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		if (volta == null) {
			if (other.volta != null)
				return false;
		} else if (!volta.equals(other.volta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return /*"PilotoVoltaPO [piloto=" + piloto + */", volta=" + volta + ", hora=" + hora 
				+ ", tempo=" + tempo + ", velocidadeMedia=" + velocidadeMedia + "]";
	}
	
	

}
