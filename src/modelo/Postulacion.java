package modelo;

import java.util.Date;

import javax.swing.JOptionPane;

import Mockeador.Mockeador;
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
	
	public Postulacion() {
		// TODO Auto-generated constructor stub
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
		return this.fechaPostu.getYear();
	}
	
	public int getDia()
	{
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
		try {				
			Mockeador.getInstancia().registrarPostulacion(pub, postu);			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
