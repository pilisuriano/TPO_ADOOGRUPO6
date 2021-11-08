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
	private List<String> tareas;
	private ModalidadContrato modalidad;
	private TipoTrabajo tipo;
	private String lugarTrabajo;
	private String categoria;
	private List<String> requisitos;
	private float sueldo;
	private boolean activa;
	
	public PublicacionVO()
	{
		tareas = new ArrayList<String>();
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
	
	public List<String> getRequisitos()
	{
		return this.requisitos;
	}
	
	public boolean esRemotoYPartTime()
	{
		return this.modalidad == ModalidadContrato.PART_TIME &&
				this.tipo == TipoTrabajo.REMOTO;
	}
	
	public String getTareasStr() {
		return String.join(" ", tareas);
	}

	public List<String> getTareas()
	{
		return this.tareas;
	}
	
	public void setDescripcion(List<String> tareas) {
		this.tareas = tareas;
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

	public void agregarTareas(String str) {
		// TODO Auto-generated method stub
		this.tareas.add(str);
	}
}
