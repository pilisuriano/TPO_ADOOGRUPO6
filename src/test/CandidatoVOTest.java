package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import modelo.vo.CandidatoVO;

public class CandidatoVOTest {
	@Test
	public void agregarUnIdioma() {
		CandidatoVO candidato = new CandidatoVO();
		
		candidato.agregarIdioma("Español");
		List<String> idiomasCandidato = candidato.getIdiomas();
		
		List<String> idiomas = new ArrayList<String>();
		idiomas.add("Español");
		
		assertEquals(idiomas, idiomasCandidato);
	}
	
	@Test
	public void agregarTresIdiomas() {
		CandidatoVO candidato = new CandidatoVO();
		
		candidato.agregarIdioma("Español");
		candidato.agregarIdioma("Ingles");
		candidato.agregarIdioma("Portugues");
		List<String> idiomasCandidato = candidato.getIdiomas();
		
		List<String> idiomas = new ArrayList<String>();
		idiomas.add("Español");
		idiomas.add("Ingles");
		idiomas.add("Portugues");
		
		assertEquals(idiomas, idiomasCandidato);
	}
	
	@Test
	public void agregarDNI() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.setDNI(38212321);
		
		int dni = candidato.getDNI();
		assertEquals(38212321, dni);
	}

	@Test
	public void agregarInteresesArray() {
		CandidatoVO candidato = new CandidatoVO();
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Python");
		intereses.add("Playwright");
		candidato.setIntereses(intereses);
		
		int cantidadIntereses = candidato.getIntereses().size();
		assertEquals(2, cantidadIntereses);
		
		ArrayList<String> interesesCandidato = candidato.getIntereses();
		
		assertEquals(intereses, interesesCandidato);
	}
	
	@Test
	public void agregarInteresesStr() {
		CandidatoVO candidato = new CandidatoVO();
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Python");
		intereses.add("Playwright");
		candidato.agregarInteres("Python");
		candidato.agregarInteres("Playwright");
		
		int cantidadIntereses = candidato.getIntereses().size();
		assertEquals(2, cantidadIntereses);
		
		ArrayList<String> interesesCandidato = candidato.getIntereses();
		
		assertEquals(intereses, interesesCandidato);
	}
	
	@Test
	public void agregarNacionalidad() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarNacionalidad("Argentino");
		
		ArrayList<String> nacionalidades = candidato.getNacionalidades();
		
		ArrayList<String> nacionalidadesValidacion = new ArrayList<String>();
		nacionalidadesValidacion.add("Argentino");
		
		assertEquals(nacionalidadesValidacion, nacionalidades);
	}
	
	@Test
	public void agregarNacionalidadDuplicada() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarNacionalidad("Argentino");
		candidato.agregarNacionalidad("Argentino");
		
		ArrayList<String> nacionalidades = candidato.getNacionalidades();
		
		ArrayList<String> nacionalidadesValidacion = new ArrayList<String>();
		nacionalidadesValidacion.add("Argentino");
		
		assertEquals(nacionalidadesValidacion, nacionalidades);
	}
	
	@Test
	public void removerNacionalidad() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarNacionalidad("Argentino");
		candidato.removerNacionalidad("Argentino");
		
		ArrayList<String> nacionalidades = candidato.getNacionalidades();
		
		ArrayList<String> nacionalidadesValidacion = new ArrayList<String>();
		
		assertEquals(nacionalidadesValidacion, nacionalidades);
	}
	
	@Test
	public void removerNacionalidadInexistente() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.removerNacionalidad("Argentino");
		
		ArrayList<String> nacionalidades = candidato.getNacionalidades();
		
		ArrayList<String> nacionalidadesValidacion = new ArrayList<String>();
		
		assertEquals(nacionalidadesValidacion, nacionalidades);
	}
	
	@Test
	public void agregarNombre() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.setNombre("Jaimito");
		
		assertEquals("Jaimito", candidato.getNombre());
	}
	
	@Test
	public void agregarApellido() {
		CandidatoVO candidato = new CandidatoVO();
		candidato.setApellido("Perez Montero");
		
		assertEquals("Perez Montero", candidato.getApellido());
	}
	
	@Test
	public void agregarFechaNacimiento() throws ParseException {
		CandidatoVO candidato = new CandidatoVO();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    Date date = formatter.parse("03-12-1996");

		candidato.setFechaNacimiento(03,12,1996);
		
		assertEquals(date, candidato.getFechaNacimiento());
	}	
}