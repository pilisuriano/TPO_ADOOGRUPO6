package test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controlador.PublicacionController;
import modelo.Publicacion.ModalidadContrato;
import modelo.Publicacion.TipoTrabajo;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import modelo.vo.ReporteVO;
import patrones.FormatoExportar;

public class PublicacionControllerTest {	
	@Test
	public void crearPublicacionValida() {
		PublicacionController reporte = new PublicacionController();
		
		int cantAnterior = reporte.getPublicacionesActivas().size();
		
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
		
		reporte.crearPublicacion(itemPublicacion);
		
		int cantNueva = reporte.getPublicacionesActivas().size();
		
		assertEquals(cantAnterior+1, cantNueva);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void obtenerPublicacionesActivas() {
		PublicacionController reporte = new PublicacionController();
		List<PublicacionVO> publicaciones = reporte.getPublicacionesActivas();
		
		assertThat(publicaciones.get(0), instanceOf(PublicacionVO.class));
	}
	
	@Test
	public void exportarImagenJPG() {
		PublicacionController reporte = new PublicacionController();
		
		PublicacionVO itemPublicacion = new PublicacionVO();
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
		
		
		reporte.exportarImagen(itemPublicacion, FormatoExportar.JPG);
	}
	
	@Test
	public void exportarImagenPNG() {
		PublicacionController reporte = new PublicacionController();
		
		PublicacionVO itemPublicacion = new PublicacionVO();
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
		
		
		reporte.exportarImagen(itemPublicacion, FormatoExportar.PNG);
	}
	
	@Test
	public void exportarImagenSVG() {
		PublicacionController reporte = new PublicacionController();
		
		PublicacionVO itemPublicacion = new PublicacionVO();
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
		
		
		reporte.exportarImagen(itemPublicacion, FormatoExportar.SVG);
	}

	@Test
	public void registrarPostulacion() {
		PublicacionController reporte = new PublicacionController();
				
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
		
		reporte.crearPublicacion(itemPublicacion);
		
		reporte.registrarPostulacion(itemPublicacion, postulacion);	
	}
}
