package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import modelo.Publicacion;
import modelo.dao.PublicacionDAO;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import modelo.Publicacion.ModalidadContrato;
import modelo.Publicacion.TipoTrabajo;

public class PublicacionTest {

	@Test
	public void crearPublicacion() {
		Publicacion publicacion = new Publicacion();
		int cantAnterior = publicacion.getPublicaciones().size();

		PublicacionVO itemPublicacion = new PublicacionVO();
		
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarIdioma("Español");
		candidato.agregarInteres("React");
		candidato.agregarNacionalidad("Argentino");
		candidato.setFechaNacimiento(03, 12, 1996);
		candidato.setNombre("Helena");
		candidato.setApellido("Perez");
		candidato.setDNI(23423123);

		PostulacionVO postulacion = new PostulacionVO();
		postulacion.setAnio(2020);
		postulacion.setMes(10);
		
		postulacion.setCandidato(candidato);
		List<PostulacionVO> postulaciones = new ArrayList<PostulacionVO>();
		postulaciones.add(postulacion);
		
		itemPublicacion.setPostulaciones(postulaciones);
		
		ModalidadContrato modalidad = null;
		itemPublicacion.setModalidad(modalidad.PART_TIME);
		
		TipoTrabajo tipo = null;
		itemPublicacion.setTipoTrabajo(tipo.REMOTO);
		
		List<String> tareas = new ArrayList<String>();
		tareas.add("Git");
		tareas.add("JUnit");
		itemPublicacion.setDescripcion(tareas);
		itemPublicacion.agregarRequisito("React");
		itemPublicacion.agregarTareas("Programar");
		itemPublicacion.setActiva(false);
		itemPublicacion.setTitulo("Titulo prueba");
		itemPublicacion.setSueldo(50000f);
		itemPublicacion.setLugarTrabajo("Charcas 2000, CABA");
		itemPublicacion.setCategoria("Sistemas");
		
		publicacion.registrarPublicacion(itemPublicacion);
		
		int cantNueva = publicacion.getPublicaciones().size();
		
		assertEquals(cantAnterior+1, cantNueva);
	}
	
	@Test
	public void obtenerPublicacionesActivas() {
		Publicacion publicacion = new Publicacion();
		PublicacionVO itemPublicacion = new PublicacionVO();
		
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarIdioma("Español");
		candidato.agregarInteres("React");
		candidato.agregarNacionalidad("Argentino");
		candidato.setFechaNacimiento(03, 12, 1996);
		candidato.setNombre("Helena");
		candidato.setApellido("Perez");
		candidato.setDNI(23423123);

		PostulacionVO postulacion = new PostulacionVO();
		postulacion.setAnio(2020);
		postulacion.setMes(10);
		
		postulacion.setCandidato(candidato);
		List<PostulacionVO> postulaciones = new ArrayList<PostulacionVO>();
		postulaciones.add(postulacion);
		
		itemPublicacion.setPostulaciones(postulaciones);
		
		ModalidadContrato modalidad = null;
		itemPublicacion.setModalidad(modalidad.PART_TIME);
		
		TipoTrabajo tipo = null;
		itemPublicacion.setTipoTrabajo(tipo.REMOTO);
		
		List<String> tareas = new ArrayList<String>();
		tareas.add("Git");
		tareas.add("JUnit");
		itemPublicacion.setDescripcion(tareas);
		itemPublicacion.agregarRequisito("React");
		itemPublicacion.agregarTareas("Programar");
		itemPublicacion.setActiva(true);
		itemPublicacion.setTitulo("Titulo prueba");
		itemPublicacion.setSueldo(50000f);
		itemPublicacion.setLugarTrabajo("Charcas 2000, CABA");
		itemPublicacion.setCategoria("Sistemas");
		
		publicacion.registrarPublicacion(itemPublicacion);
		
		int cantidadPublicaciones = publicacion.getPublicacionesActivas().size();
		
		Assert.assertTrue(cantidadPublicaciones > 0);
	}
	
	@Test
	public void obtenerPublicacionesPartTimeYRemotas() {
		Publicacion publicacion = new Publicacion();
		PublicacionVO itemPublicacion = new PublicacionVO();
		
		CandidatoVO candidato = new CandidatoVO();
		candidato.agregarIdioma("Español");
		candidato.agregarInteres("React");
		candidato.agregarNacionalidad("Argentino");
		candidato.setFechaNacimiento(03, 12, 1996);
		candidato.setNombre("Helena");
		candidato.setApellido("Perez");
		candidato.setDNI(23423123);

		PostulacionVO postulacion = new PostulacionVO();
		postulacion.setAnio(2020);
		postulacion.setMes(10);
		
		postulacion.setCandidato(candidato);
		List<PostulacionVO> postulaciones = new ArrayList<PostulacionVO>();
		postulaciones.add(postulacion);
		
		itemPublicacion.setPostulaciones(postulaciones);
		
		ModalidadContrato modalidad = null;
		itemPublicacion.setModalidad(modalidad.PART_TIME);
		
		TipoTrabajo tipo = null;
		itemPublicacion.setTipoTrabajo(tipo.REMOTO);
		
		List<String> tareas = new ArrayList<String>();
		tareas.add("Git");
		tareas.add("JUnit");
		itemPublicacion.setDescripcion(tareas);
		itemPublicacion.agregarRequisito("React");
		itemPublicacion.agregarTareas("Programar");
		itemPublicacion.setActiva(true);
		itemPublicacion.setTitulo("Titulo prueba");
		itemPublicacion.setSueldo(50000f);
		itemPublicacion.setLugarTrabajo("Charcas 2000, CABA");
		itemPublicacion.setCategoria("Sistemas");
		
		publicacion.registrarPublicacion(itemPublicacion);
		
		int cantidadPublicaciones = publicacion.getPublicacioneRemotasYPartTime().size();
		
		Assert.assertTrue(cantidadPublicaciones > 0);
	}
}
