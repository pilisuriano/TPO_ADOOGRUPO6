package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Mockeador.Mockeador;
import modelo.dao.CandidatoDAO;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import patrones.IObservable;
import patrones.MedioNotificacion;
import patrones.Notificacion;
import patrones.SistemaNotificador;

public class Candidato implements IObservable
{
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer DNI;
	private List<String> nacionalidades;
	private List<String> idiomas;
	private List<String> intereses;
	private List<Publicacion> favoritos;
	private String email;
	
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
	
	public List<String> getNacionalidades()
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

	public List<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public List<String> getIntereses() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void postulacionRealizada(PostulacionVO post, PublicacionVO pub) {
		// TODO Auto-generated method stub
		if (post.getCandidato().getDNI() != this.getDNI())
			return;
		
		Notificacion not = new Notificacion();
		
		not.setRemitente("Sistema RRHH");
		String msj = "Su postulacion ha sido recibida existosamente, en breve la empresa lo contactara Sr: " + this.nombre + " " + this.apellido;
		not.setMsj(msj);
		not.setDestinatario(this.email);
		
		SistemaNotificador.getInstancia().enviarNotificacion(not, MedioNotificacion.EMAIL);
	}

	public List<Publicacion> getPublicacionesFavoritas() {
		return favoritos;
	}

	public void setPublicacionesFavoritas(List<Publicacion> favoritos) {
		this.favoritos = favoritos;
	}
	
	public boolean tieneFavorita(Publicacion p)
	{
		for (Publicacion itr : this.favoritos)
		{
			if (p.getIdPublicacion() == itr.getIdPublicacion())
				return true;
		}
		
		return false;
	}
}
