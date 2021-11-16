package modelo.vo;

import modelo.Postulacion;

public class PostulacionVO 
{
	private Integer mes;
	private Integer anio;
	private Integer dia;
	private CandidatoVO candidato;
	private float renumeracion;
	
	public PostulacionVO(Postulacion postulacion) 
	{
		// TODO Auto-generated constructor stub
		mes = postulacion.getMes();
		anio = postulacion.getAnio();
		dia = postulacion.getDia();
		
		candidato = postulacion.getCandidato().getCandidatoVO();
		renumeracion = postulacion.getRenumeracion();
	}
	
	public PostulacionVO() {
		// TODO Auto-generated constructor stub
		candidato = new CandidatoVO();
	}

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
