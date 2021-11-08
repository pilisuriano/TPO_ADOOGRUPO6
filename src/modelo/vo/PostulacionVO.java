package modelo.vo;

import java.util.List;

public class PostulacionVO {
	private Integer mes;
	private Integer anio;
	private CandidatoVO candidato;
	private Integer remuneracion;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public CandidatoVO getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoVO candidato) {
		this.candidato = candidato;
	}

	public void setRemuneracion(Integer remuneracion) {
		this.remuneracion = remuneracion;
	}

	public Integer getRemuneracion() {
		return remuneracion;
	}
}
