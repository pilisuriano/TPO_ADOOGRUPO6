package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.dao.PublicacionDAO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;


public class Publicacion {

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

	public Publicacion(List<Postulacion> postulaciones,
					   String titulo,
					   List<String> tareas,
					   ModalidadContrato modalidad,
					   TipoTrabajo tipo,
					   String lugarTrabajo,
					   String categoria,
					   List<String> requisitos,
					   float sueldo,
					   boolean activa) {
		this.postulaciones = postulaciones;
		this.titulo = titulo;
		this.tareas = tareas;
		this.modalidad = modalidad;
		this.tipo = tipo;
		this.lugarTrabajo = lugarTrabajo;
		this.categoria = categoria;
		this.requisitos = requisitos;
		this.sueldo = sueldo;
		this.activa = activa;
	}
	
	public List<PublicacionVO> getPublicaciones() {
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicaciones();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public List<PublicacionVO> getPublicacioneRemotasYPartTime()
	{
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicacionesRemotasYPartTime();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public List<PublicacionVO> getPublicacionesActivas() {
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicacionesActivas();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public void registrarPublicacion(PublicacionVO pub)
	{
		PublicacionDAO pubDAO;
		
		try {				
			pubDAO = new PublicacionDAO();
			pubDAO.registrarPublicacion(pub);
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

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
