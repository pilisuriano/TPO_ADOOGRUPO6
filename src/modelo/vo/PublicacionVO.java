package modelo.vo;

import java.util.ArrayList;
import java.util.List;

import modelo.Postulacion;
import modelo.Publicacion;
import modelo.Publicacion.ModalidadContrato;
import modelo.Publicacion.TipoTrabajo;
import patrones.MedioNotificacion;

public class PublicacionVO 
{
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
	private int idPublicacion;
	private MedioNotificacion medioNotificacion;
	
	public PublicacionVO()
	{
		tareas = new ArrayList<String>();
		requisitos = new ArrayList<String>();
		tipo = TipoTrabajo.PRESENCIAL;
		modalidad = ModalidadContrato.FULL_TIME;
		postulaciones = new ArrayList<PostulacionVO>();
	}
	
	public PublicacionVO(Publicacion value)
	{
		// TODO Auto-generated constructor stub
		titulo = value.getTitulo();
		tareas = new ArrayList<String>(value.getTareas());
		modalidad = value.getModalidad();
		tipo = value.getTipo();
		lugarTrabajo = value.getLugarTrabajo();
		categoria = value.getCategoria();
		requisitos = new ArrayList<String>(value.getRequisitos());
		sueldo = value.getSueldo();
		activa = value.isActiva();
		medioNotificacion = value.getMedioNotificacion();
		postulaciones = new ArrayList<PostulacionVO>();
		
		for (Postulacion itr : value.getPostulaciones())
		{
			PostulacionVO post = new PostulacionVO(itr);
			postulaciones.add(post);
		}
		
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
		if(!requisito.equals("")) {
			if(this.requisitos.size() == 0)
				this.requisitos.add(requisito);
			else { 
		        for (String i : this.requisitos) {
		            if (!this.requisitos.contains(requisito)) {
		                this.requisitos.add(requisito);
		            }
		        }
			}
		}
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
		if(Float.compare(f, 0f) == 0) throw new IllegalArgumentException("No se puede asignar un sueldo cero");
		else if(Float.compare(f, 0f) < 0) throw new IllegalArgumentException("No se puede asignar un sueldo negativo");
		else this.sueldo = f;
;
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
		if(!str.equals("")) {
            this.tareas.add(str);
		}
	}

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public MedioNotificacion getMedioNotificacion() {
		return medioNotificacion;
	}

	public void setMedioNotificacion(MedioNotificacion medioNotificacion) {
		this.medioNotificacion = medioNotificacion;
	}

	public ModalidadContrato getModalidadContrato() {
		// TODO Auto-generated method stub
		return this.modalidad;
	}

	public TipoTrabajo getTipoTrabajo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}
}
