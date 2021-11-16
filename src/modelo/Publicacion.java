package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Mockeador.Mockeador;
import modelo.vo.PublicacionVO;
import patrones.MedioNotificacion;


public class Publicacion
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
	
	private int idPublicacion;
	private List<Postulacion> postulaciones;
	private String titulo;
	private List<String> tareas;
	private ModalidadContrato modalidad;
	private TipoTrabajo tipo;
	private String lugarTrabajo;
	private String categoria;
	private List<String> requisitos;
	private float sueldo;
	private boolean activa;
	private MedioNotificacion medioNoti;
	private Empresa empresa;

	public Publicacion()
	{
		this.tareas = new ArrayList<String>();
		this.requisitos = new ArrayList<String>();
		this.postulaciones = new ArrayList<Postulacion>();
	}
	
	public List<PublicacionVO> getPublicaciones() {
		
		try {				
			return Mockeador.getInstancia().getPublicaciones();	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public List<PublicacionVO> getPublicacioneRemotasYPartTime()
	{
		try {				
			return Mockeador.getInstancia().getPublicacionesRemotasYPartTime();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public List<PublicacionVO> getPublicacionesActivas() {
		try {				
			return Mockeador.getInstancia().getPublicacionesActivas();	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public void registrarPublicacion(PublicacionVO pub)
	{
		try {				
			Mockeador.getInstancia().registrarPublicacion(pub);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}

	public void setPostulaciones(List<Postulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getTareas() {
		return tareas;
	}

	public void setTareas(List<String> tareas) {
		this.tareas = tareas;
	}

	public ModalidadContrato getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadContrato modalidad) {
		this.modalidad = modalidad;
	}

	public TipoTrabajo getTipo() {
		return tipo;
	}

	public void setTipo(TipoTrabajo tipo) {
		this.tipo = tipo;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<String> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<String> requisitos) {
		this.requisitos = requisitos;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isActiva() {
		return activa;
	}
	
	public boolean esRemotaYPartTime()
	{
		return this.modalidad == ModalidadContrato.PART_TIME &&
				this.tipo == TipoTrabajo.REMOTO;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public MedioNotificacion getMedioNotificacion() {
		return medioNoti;
	}

	public void setMedioNotificacion(MedioNotificacion medioNoti) {
		this.medioNoti = medioNoti;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
}
