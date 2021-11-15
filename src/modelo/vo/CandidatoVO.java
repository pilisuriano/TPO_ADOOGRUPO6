package modelo.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CandidatoVO 
{
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer DNI;
	private ArrayList<String> nacionalidades;
	private ArrayList<String> idiomas;
	private ArrayList<String> intereses;
	
	public CandidatoVO()
	{
		this.nacionalidades = new ArrayList<String>();
		this.setIdiomas(new ArrayList<String>());
		this.setIntereses(new ArrayList<String>());
	}
	
	public void setFechaNacimiento(int dia, int mes, int year)
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    try {
			Date date = formatter.parse("03-12-1996");
			this.fechaNacimiento = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

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
	
}
