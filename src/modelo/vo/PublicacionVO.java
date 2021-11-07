package modelo.vo;

import java.util.ArrayList;
import java.util.List;

public class PublicacionVO 
{
	public enum ModalidadContrato
	{
		PART_TIME,
		FULL_TIME,
	};
	
	public enum TipoTrabajo
	{
		PRESENCIAL,
		REMOTO,
	};
	
	private List<PostulacionVO> postulaciones;
	private String titulo;
	private String descripcion;
	private ModalidadContrato modalidad;
	private TipoTrabajo tipo;
	private String lugarTrabajo;
	private String categoria;
	private ArrayList<String> requisitos;
	private float sueldo;
	private boolean activa;
	
	public PublicacionVO()
	{
		requisitos = new ArrayList<String>();
		tipo = TipoTrabajo.PRESENCIAL;
		modalidad = ModalidadContrato.FULL_TIME;
	}
	
	public String getModalidadStr()
	{
		if (modalidad.equals(ModalidadContrato.PART_TIME))
			return "Part-Time";
		else
			return "Full-Time";
	}
	
	public String getTipoTrabajoStr()
	{
		if (this.tipo.equals(TipoTrabajo.PRESENCIAL))
			return "Presencial";
		else
			return "Remoto";
	}
	
	public String getRequisitosStr()
	{
		return String.join(" ", this.requisitos);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void agregarRequisito(String requisito)
	{
		this.requisitos.add(requisito);
	}
	
	public void eliminarRequisito(String requisito)
	{
		int pos = this.requisitos.indexOf(requisito);
		
		if (pos != -1)
			this.requisitos.remove(pos);
	}
	
	public void setTipoTrabajo(TipoTrabajo tipo)
	{
		this.tipo = tipo;
	}
	
	public void setModalidad(ModalidadContrato modalidad)
	{
		this.modalidad = modalidad;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float f) {
		this.sueldo = f;
	}
	public List<PostulacionVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<PostulacionVO> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
