package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import modelo.Empresa;
import modelo.Publicacion;
import modelo.Publicacion.ModalidadContrato;
import modelo.Publicacion.TipoTrabajo;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

public class EmpresaTest {
	@Test
	public void asignarEmailValido() {
		Empresa empresa = new Empresa();
		empresa.setEmail("test@gmail.com");
		
		assertEquals("test@gmail.com", empresa.getEmail());
	}
	
	@Test
	public void asignarRazonSocialValida() {
		Empresa empresa = new Empresa();
		empresa.setRazonSocial("Coca Cola");
		
		assertEquals("Coca Cola", empresa.getRazonSocial());
	}
	
	@Test
	public void asignarTlf() {
		Empresa empresa = new Empresa();
		empresa.setTlf(42);
		
		assertEquals(42, empresa.getTlf());
	}
	
	@Test
	public void agregarPublicacionAEmpresa() {
		Empresa empresa = new Empresa();
		
		Publicacion itemPublicacion = new Publicacion();
		ModalidadContrato modalidad = null;
		itemPublicacion.setModalidad(modalidad.PART_TIME);
		
		TipoTrabajo tipo = null;
		itemPublicacion.setTipo(tipo.REMOTO);
		
		List<String> requisitos = new ArrayList<String>();
		requisitos.add("Git");
		requisitos.add("JUnit");
		itemPublicacion.setCategoria("Git;JUnit");
		itemPublicacion.setTareas(requisitos);
		itemPublicacion.setActiva(true);
		itemPublicacion.setTitulo("Titulo prueba");
		itemPublicacion.setSueldo(50000f);
		itemPublicacion.setLugarTrabajo("Charcas 2000, CABA");
		itemPublicacion.setCategoria("Sistemas");
		
		empresa.agregarPublicacion(itemPublicacion);
		
		empresa.eliminarPublicacion(itemPublicacion);
	}
	
	
}
