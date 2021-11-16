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
		if(mes >= 1 && mes <= 12) this.mes = mes;
		else throw new IllegalArgumentException("El mes debe estar entre los valores 1 y 12");
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		if(anio > 0) this.anio = anio;
		else throw new IllegalArgumentException("A�o invalido");
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
