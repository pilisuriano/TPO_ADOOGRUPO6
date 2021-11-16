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
		CandidatoVO candidato = new CandidatoVO();
		candidato.setDNI(10234234);
		candidato.setFechaNacimiento(3, 12, 1996);
		
		candidatoController.registrarCandidato(candidato);
		
		CandidatoVO candidatoTest = candidatoController.buscarCandidato(10234234);
		
		assertThat(candidatoTest, instanceOf(CandidatoVO.class));
		assertEquals(10234234, candidato.getDNI());
	}
	
	@Test
	public void buscarCandidatoInexistente() {
		CandidatoController candidatoController = new CandidatoController();
		
		try{
			CandidatoVO candidato = candidatoController.buscarCandidato(-23723);
			assertTrue(true);
		} catch(Exception e) {
			fail("Deberia obtenerse excepcion");
		}
	}
	
	@Test
	public void registrarCandidato() {
		CandidatoController candidatoController = new CandidatoController();
		
		CandidatoVO candidato = new CandidatoVO();
		candidato.setDNI(38212321);
		candidato.setFechaNacimiento(3, 12, 1996);
		
		try{
			candidatoController.registrarCandidato(candidato);
		} catch(Exception e) {
			fail("Deberia obtenerse excepcion");
		}
	}
}
