package modelo.vo;

public class PostulacionVO 
{
	private Integer mes;
	private Integer anio;
	private Integer dia;
	private CandidatoVO candidato;
	private float renumeracion;
	
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
	public float getRenumeracion() {
		return renumeracion;
	}
	public void setRenumeracion(float renumeracion) {
		this.renumeracion = renumeracion;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
}
