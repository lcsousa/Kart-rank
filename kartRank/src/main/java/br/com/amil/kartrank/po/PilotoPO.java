package br.com.amil.kartrank.po;

import java.util.List;

import br.com.amil.kartrank.util.DateUtil;

public class PilotoPO {
	
	private String codigo;
	private String nome;
	private List<PilotoVoltaPO> listaPilotoVolta;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<PilotoVoltaPO> getListaPilotoVolta() {
		return listaPilotoVolta;
	}
	public void setListaPilotoVolta(List<PilotoVoltaPO> listaPilotoVolta) {
		this.listaPilotoVolta = listaPilotoVolta;
	}
	
	public int getQuantidadeVoltas(){
		return listaPilotoVolta == null?0:listaPilotoVolta.size();
	}
	
	public Long getTempoTotal() {
		Long tempoTotal = 0L;
		for (PilotoVoltaPO pilotoVolta : listaPilotoVolta) {
			tempoTotal += pilotoVolta.getTempoVoltaInteiro();
		}
		return tempoTotal;
	}
	
	public String getStTempoTotal() {
		Long tempoTotal = getTempoTotal();
		return DateUtil.converterInteiroEmEmHorario(tempoTotal);
	}
	
	@Override
	public String toString() {
		return "PilotoPO [codigo=" + codigo + ", nome=" + nome + ", ListaPilotoVolta=" + listaPilotoVolta + " TEMPO TOTAL:"+getTempoTotal()+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		PilotoPO other = (PilotoPO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
