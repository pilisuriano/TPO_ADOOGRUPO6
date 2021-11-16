package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;

public class PostulacionVOTest {
	@Test
	public void postulacionConAnioValido() {
		PostulacionVO postulacion = new PostulacionVO();
		postulacion.setAnio(1990);
		int anio = postulacion.getAnio();
		
		assertEquals(1990,anio);
	}
	
	@Test
	public void postulacionConAnioInvalido() {
		PostulacionVO postulacion = new PostulacionVO();
		try{
			postulacion.setAnio(-1990);
			fail("Deberia obtenerse excepcion");
		} catch(Exception e) {
			assertEquals(e.getMessage(), "Año invalido");
		}
	}
	
	@Test
	public void postulacionConMesValido() {
		PostulacionVO postulacion = new PostulacionVO();
		postulacion.setMes(12);
		int mes = postulacion.getMes();
		
		assertEquals(12, mes);
	}
	
	@Test
	public void postulacionConMesInvalido() {
		PostulacionVO postulacion = new PostulacionVO();
		try{
			postulacion.setMes(14);
			fail("Deberia obtenerse excepcion");
		} catch(Exception e) {
			assertEquals(e.getMessage(), "El mes debe estar entre los valores 1 y 12");
		}
	}
	
	@Test
	public void generarPostulacionConCandidato() {
		PostulacionVO postulacion = new PostulacionVO();
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarIdioma("Español");
		candidato.agregarInteres("React");
		candidato.agregarNacionalidad("Argentino");
		candidato.setFechaNacimiento(03, 12, 1996);
		candidato.setNombre("Helena");
		candidato.setApellido("Perez");
		candidato.setDNI(23423123);
		postulacion.setCandidato(candidato);
		
		int dni = postulacion.getCandidato().getDNI();
		
		assertEquals(23423123,dni);
	}
	
}
