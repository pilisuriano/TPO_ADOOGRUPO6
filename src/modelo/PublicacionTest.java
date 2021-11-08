package modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.rules.ExpectedException;

import org.junit.Test;
import modelo.Publicacion;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import modelo.vo.PublicacionVO.ModalidadContrato;
import modelo.vo.PublicacionVO.TipoTrabajo;

public class PublicacionTest {

	@Test
	public void agregarTarea() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarTareas("Programar");
		String tarea = publicacion.getTareasStr();
		
		assertEquals("Programar", tarea);
	}
	
	@Test
	public void agregarTareaDuplicada() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarTareas("Programar");
		publicacion.agregarTareas("Programar");
		String tarea = publicacion.getTareasStr();
		
		assertEquals("Programar", tarea);
	}
	
	@Test
	public void agregarTareaVacia() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarTareas("");
		String tarea = publicacion.getTareasStr();
		
		assertEquals("", tarea);
	}

	@Test
	public void agregarTareas() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarTareas("Programar");
		publicacion.agregarTareas("ELK");
		List<String> tareas = publicacion.getTareas();
		
		List<String> listaComparacion = new ArrayList<String>();
		listaComparacion.add("Programar");
		listaComparacion.add("ELK");
		
		assertEquals(listaComparacion, tareas);
	}
	
	@Test
	public void agregarRequisito() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarRequisito("React");
		List<String> listaPublicaciones = publicacion.getRequisitos();
		
		List<String> lista = new ArrayList<String>();
		lista.add("React");
		
		assertEquals(lista, listaPublicaciones);
	}
	
	@Test
	public void agregarRequisitoDuplicado() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarRequisito("React");
		publicacion.agregarRequisito("React");
		List<String> listaPublicaciones = publicacion.getRequisitos();
		
		List<String> lista = new ArrayList<String>();
		lista.add("React");
		
		assertEquals(lista, listaPublicaciones);
	}
	
	@Test
	public void agregarRequisitoVacio() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarRequisito("");
		List<String> listaPublicaciones = publicacion.getRequisitos();
		
		List<String> lista = new ArrayList<String>();
		
		assertEquals(lista, listaPublicaciones);
	}
	
	@Test
	public void eliminarRequisito() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarRequisito("React");
		publicacion.eliminarRequisito("React");
		List<String> listaPublicaciones = publicacion.getRequisitos();
		
		assertEquals(new ArrayList<String>(), listaPublicaciones);
	}
	
	@Test
	public void eliminarRequisitoInexistente() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.eliminarRequisito("React");
		List<String> listaPublicaciones = publicacion.getRequisitos();
		
		assertEquals(new ArrayList<String>(), listaPublicaciones);
	}
	
	@Test
	public void verificarFullTime() {
		PublicacionVO publicacion = new PublicacionVO();
		ModalidadContrato modalidad = null;
		
		publicacion.setModalidad(modalidad.FULL_TIME);
		String modalidadTexto = publicacion.getModalidadStr();
		
		assertEquals("Full-Time", modalidadTexto);
		
		publicacion.setModalidad(modalidad.PART_TIME);
		
		modalidadTexto = publicacion.getModalidadStr();
		
		assertEquals("Part-Time", modalidadTexto);
	}
	
	@Test
	public void verificarCategoria() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setCategoria("RRHH");
		String categoria = publicacion.getCategoria();
		
		assertEquals("RRHH", categoria);
	}
	
	@Test
	public void asignarCategoriaVacia() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setCategoria("");
		String categoria = publicacion.getCategoria();
		
		assertEquals("", categoria);
	}
	
	@Test
	public void verificarLugarTrabajo() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setLugarTrabajo("Charcas 2000, CABA");
		String lugarTrabajo = publicacion.getLugarTrabajo();
		
		assertEquals("Charcas 2000, CABA", lugarTrabajo);
	}
	
	@Test
	public void asignarLugarTrabajoVacio() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setLugarTrabajo("");
		String lugarTrabajo = publicacion.getLugarTrabajo();
		
		assertEquals("", lugarTrabajo);
	}
	
	@Test
	public void verificarSueldo() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setSueldo(50000f);
		float sueldo = publicacion.getSueldo();
		
		assertEquals(50000f, sueldo, 0f);
	}
	
	@Test
	public void verificarSueldoNegativo() throws Exception {
		try{
			PublicacionVO publicacion = new PublicacionVO();
			publicacion.setSueldo(-500f);     
			fail("Deberia obtenerse excepcion");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No se puede asignar un sueldo negativo");
		}
	}
	
	@Test
	public void verificarSueldoCero() throws Exception {
		try{
			PublicacionVO publicacion = new PublicacionVO();
			publicacion.setSueldo(0);     
			fail("Deberia obtenerse excepcion");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No se puede asignar un sueldo cero");
		}
	}
	
	@Test
	public void verificarTitulo() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setTitulo("Titulo prueba");
		String titulo = publicacion.getTitulo();
		
		assertEquals("Titulo prueba", titulo);
	}
	
	@Test
	public void verificarEstado() {
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.setActiva(true);
		Boolean estado = publicacion.isActiva();
		assertTrue(estado);
		
		publicacion.setActiva(false);
		estado = publicacion.isActiva();
		assertFalse(estado);
	}
	
	@Test
	public void verificarDescripcion() {
		PublicacionVO publicacion = new PublicacionVO();
		List<String> tareas = new ArrayList<String>();
		tareas.add("Git");
		tareas.add("JUnit");
		publicacion.setDescripcion(tareas);
		String tareasStr = publicacion.getTareasStr();
		List<String> tareasList = publicacion.getTareas();
		
		assertEquals(tareas,tareasList);
		assertEquals("Git JUnit",tareasStr);
	}
	
	@Test
	public void verificarTipoTrabajo() {
		PublicacionVO publicacion = new PublicacionVO();
		TipoTrabajo tipo = null;
		
		publicacion.setTipoTrabajo(tipo.REMOTO);
		String tipoTrabajo = publicacion.getTipoTrabajoStr();
		assertEquals("Remoto",tipoTrabajo);
		
		publicacion.setTipoTrabajo(tipo.PRESENCIAL);
		tipoTrabajo = publicacion.getTipoTrabajoStr();
		assertEquals("Presencial",tipoTrabajo);
	}
	
	@Test
	public void agregarPostulaciones() {
		PublicacionVO publicacion = new PublicacionVO();
		List<PostulacionVO> postulaciones = new ArrayList<PostulacionVO>();
		PostulacionVO postulacion = new PostulacionVO();
		CandidatoVO candidato = new CandidatoVO();
		postulacion.setAnio(2020);
		postulacion.setMes(10);
		candidato.agregarIdioma("Español");
		candidato.agregarInteres("React");
		candidato.agregarNacionalidad("Argentino");
		candidato.setFechaNacimiento(03, 12, 1996);
		candidato.setNombre("Helena");
		candidato.setApellido("Perez");
		candidato.setDNI(23423123);
		postulacion.setCandidato(candidato);
		postulaciones.add(postulacion);
		publicacion.setPostulaciones(postulaciones);
		
		int cantidad = publicacion.getPostulaciones().size();
		
		assertEquals(1,cantidad);
	}
	
	@Test
	public void esRemotoYPart() {
		PublicacionVO publicacion = new PublicacionVO();
		ModalidadContrato modalidad = null;
		publicacion.setModalidad(modalidad.PART_TIME);
		TipoTrabajo tipo = null;
		publicacion.setTipoTrabajo(tipo.REMOTO);
		boolean verify = publicacion.esRemotoYPartTime();
		
		assertTrue(verify);
		
		publicacion.setTipoTrabajo(tipo.PRESENCIAL);
		verify = publicacion.esRemotoYPartTime();

		assertFalse(verify);
	}
	
}
