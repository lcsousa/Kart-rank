package br.com.amil.kartrank.po;

import java.util.List;

public class VoltaPO {

	private Integer numero;
	private List<PilotoVoltaPO> listaPilotoVolta;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public List<PilotoVoltaPO> getListaPilotoVolta() {
		return listaPilotoVolta;
	}
	public void setListaPilotoVolta(List<PilotoVoltaPO> listaPilotoVolta) {
		this.listaPilotoVolta = listaPilotoVolta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		VoltaPO other = (VoltaPO) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VoltaPO [numero=" + numero + /*", listaPilotoVolta=" + listaPilotoVolta+ */ "]";
	}
	
	

}
