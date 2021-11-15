package test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import controlador.CandidatoController;
import controlador.ReporteController;
import modelo.vo.CandidatoVO;
import modelo.vo.PublicacionVO;

public class CandidatoControllerTest {
	@Test
	public void buscarCandidatoExistente() {
		CandidatoController candidatoController = new CandidatoController();
		
		CandidatoVO candidato = candidatoController.buscarCandidato(1);
		
		assertNotNull(candidato);
	}
	
	@Test
	public void buscarCandidatoInexistente() {
		CandidatoController candidatoController = new CandidatoController();
		
		CandidatoVO candidato = candidatoController.buscarCandidato(-23723);
		
		assertNotNull(candidato);
	}
	
	@Test
	public void registrarCandidato() {
		CandidatoController candidatoController = new CandidatoController();
		
		CandidatoVO candidato = new CandidatoVO();
		candidato.setDNI(38212321);
		
		try{
			candidatoController.registrarCandidato(candidato);
		} catch(Exception e) {
			fail("Deberia obtenerse excepcion");
		}
	}
}
