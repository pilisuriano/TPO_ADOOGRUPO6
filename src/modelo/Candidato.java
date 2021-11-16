package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Mockeador.Mockeador;
import modelo.dao.CandidatoDAO;
import modelo.vo.CandidatoVO;

public class Candidato 
{
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer DNI;
	private ArrayList<String> nacionalidades;
	private ArrayList<String> idiomas;
	private ArrayList<String> intereses;

	public Candidato(String nombre,
					 String apellido,
					 Date fechaNacimiento,
					 Integer dni,
					 ArrayList<String> nacionalidades,
					 ArrayList<String> idiomas,
					 ArrayList<String> intereses) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.DNI = dni;
		this.nacionalidades = nacionalidades;
		this.idiomas = idiomas;
		this.intereses = intereses;
	}
	
	public void setFechaNacimiento(int dia, int mes, int year)
	{
		this.fechaNacimiento = new Date(year, mes, dia);
	}
	
	public void setFechaNacimiento(Date fecha)
	{
		this.fechaNacimiento = fecha;
	}
	
	public Candidato()
	{
		this.nacionalidades = new ArrayList<String>();
		this.idiomas = new ArrayList<String>();
		this.intereses = new ArrayList<String>();
	}
	
	public CandidatoVO getCandidatoVO()
	{
		CandidatoVO cand = new CandidatoVO();
		cand.setNombre(nombre);
		cand.setApellido(apellido);
		cand.setFechaNacimiento(fechaNacimiento.getDay(), fechaNacimiento.getMonth(), fechaNacimiento.getYear());
		cand.setDNI(DNI);
		
		for (String itr : idiomas)
			cand.agregarIdioma(itr);
		
		for (String itr : intereses)
			cand.agregarInteres(itr);
		
		for (String itr : nacionalidades)
			cand.agregarNacionalidad(itr);
		
		return cand;
	}
	
	public Date getFechaNacimiento() { return this.fechaNacimiento; }
	
	public boolean agregarNacionalidad(String nacionalidad)
	{
		if (nacionalidades.indexOf(nacionalidad) == -1)
		{
			nacionalidades.add(nacionalidad);	
			return true;
		}
		
		return false;
	}
	
	public void removerNacionalidad(String nacionalidad)
	{
		int pos = nacionalidades.indexOf(nacionalidad);
		
		if (pos != -1)
			nacionalidades.remove(pos);
	}
	
	public ArrayList<String> getNacionalidades()
	{
		return this.nacionalidades;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDNI() {
		return DNI;
	}
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}

	public void agregarIdioma(String text) {
		// TODO Auto-generated method stub
		this.idiomas.add(text);
	}

	public void agregarInteres(String interes) {
		// TODO Auto-generated method stub
		this.intereses.add(interes);
	}
	
	public List<CandidatoVO> getCandidatos()
	{
		try {
			return Mockeador.getInstancia().getCandidatos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public void registrarCandidato(CandidatoVO candidato) {
		try {				
			Mockeador.getInstancia().registrarCandidato(candidato);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public CandidatoVO buscarCandidato(int DNI) {
		
		CandidatoDAO candDAO;
		
		try 
		{
			if (DNI > 99) 
			{
				return Mockeador.getInstancia().getCandidato(DNI);						
			}else
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
}
