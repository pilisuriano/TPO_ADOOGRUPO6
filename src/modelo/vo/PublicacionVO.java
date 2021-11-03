package modelo.vo;

import java.util.List;

public class PublicacionVO {
	private String titulo;
	private Double sueldo;
	private List<PostulacionVO> postulaciones;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public List<PostulacionVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<PostulacionVO> postulaciones) {
		this.postulaciones = postulaciones;
	}
}
