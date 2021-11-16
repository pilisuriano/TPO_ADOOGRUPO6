package modelo.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Candidato;

public class CandidatoVO 
{
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer DNI;
	private ArrayList<String> nacionalidades;
	private ArrayList<String> idiomas;
	private ArrayList<String> intereses;
	private String email;
	
	public CandidatoVO()
	{
		this.nacionalidades = new ArrayList<String>();
		this.setIdiomas(new ArrayList<String>());
		this.setIntereses(new ArrayList<String>());
	}
	
	public CandidatoVO(Candidato c) {
		// TODO Auto-generated constructor stub
		nombre = c.getNombre();
		apellido = c.getApellido();
		fechaNacimiento = c.getFechaNacimiento();
		DNI = c.getDNI();
		nacionalidades = new ArrayList<String>(c.getNacionalidades());
		idiomas = new ArrayList<String>(c.getIdiomas());
		intereses = new ArrayList<String>(c.getIntereses());
	}

	public void setFechaNacimiento(int dia, int mes, int year)
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    Date date = null;
	    try {
			date = formatter.parse(dia + "-" + mes + "-" + year);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.fechaNacimiento = date;
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

	public String getInfoCandidato() {
		// TODO Auto-generated method stub
		String info = "";
		
		info += "Nombre: " + this.nombre + '\n';
		info += "Apellido: " + this.apellido + '\n';
		info += "Idiomas: " + String.join(" ", this.idiomas) + '\n';
		info += "Intereses: " + String.join(" ", this.intereses) + '\n';
		info += "Nacionalidades: " + String.join(" ", this.nacionalidades) + '\n';
		
		return info;
	}

	public void setFechaNacimiento(Date date) {
		// TODO Auto-generated method stub
		this.fechaNacimiento = date;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
