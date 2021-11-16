package modelo;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.dao.PostulacionDAO;
import modelo.dao.PublicacionDAO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

public class Postulacion 
{
	private Date fechaPostu;
	private Candidato cand;
	private float renumeracion;

	public Postulacion(Date fechaPostu,
					   Candidato cand,
					   float renumeracion) {
		this.fechaPostu = fechaPostu;
		this.cand = cand;
		this.renumeracion = renumeracion;
	}
	
	public Candidato getCandidato() {
		return cand;
	}
	public void setCandidato(Candidato cand) {
		this.cand = cand;
	}
	
	public void setRenumeracion(float renum) {
		this.renumeracion = renum;
	}
	
	public float getRenumeracion() {
		return this.renumeracion;
	}
	
	public int getMes() {
		return this.fechaPostu.getMonth();
	}
	
	public int getAnio() {
		return this.fechaPostu.getDay();
	}
	
	public Date getFechaPostulacion()
	{
		return this.fechaPostu;
	}
	
	public void setFechaPostulacion(Date fecha)
	{
		this.fechaPostu = fecha;
	}
	
	public void registrarPostulacion(PublicacionVO pub, PostulacionVO postu)
	{
		PostulacionDAO postuDAO;
		
		try {				
			postuDAO = new PostulacionDAO();
			postuDAO.registrarPostulacion(pub, postu);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
