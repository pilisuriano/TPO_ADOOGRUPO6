package test;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import controlador.ReporteController;
import modelo.vo.PublicacionVO;
import modelo.vo.ReporteVO;

public class ReporteControllerTest {
	@SuppressWarnings("deprecation")
	@Test
	public void verificarOfertaMasExigente() {
		ReporteController reporte = new ReporteController();
		PublicacionVO publicacion = reporte.getOfertaMasExigente();
		
		assertThat(publicacion, instanceOf(PublicacionVO.class));
	}
	
	@Test
	public void verificarMayorOfertasLaboralesMesValido() {
		ReporteController reporte = new ReporteController();
		ReporteVO reporteGenerado = reporte.getReporteMayorOfertasLaborales("10", "2021");
		
		System.out.println(reporteGenerado.getTitulo_oferta());
	}
	
	@Test
	public void verificarMayorOfertasLaboralesMesInvalido() {
		ReporteController reporte = new ReporteController();
		ReporteVO reporteGenerado = reporte.getReporteMayorOfertasLaborales("16", "2021");
		
		System.out.println(reporteGenerado.getTitulo_oferta());
	}
	
	@Test
	public void verificarTrabajoMasAccesible() {
		ReporteController reporte = new ReporteController();
		PublicacionVO publicacion = reporte.getTrabajoMasAccesible();
		
		System.out.println(publicacion.getCategoria());
		
		System.out.println(publicacion.getTitulo());
	}
	
	@Test
	public void obtenerPrimeras2Categorias() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.primerasMCategoriasTop(2);
		
		assertEquals(2, publicaciones.size());
	}
	
	@Test
	public void obtenerPrimerasMCategoriasInvalidas() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.primerasMCategoriasTop(-10);
		
		assertEquals(0, publicaciones.size());
	}
	
	@Test
	public void obtenerPrimeras999Categorias() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.primerasMCategoriasTop(999);
		
		assertEquals(3, publicaciones.size());
	}
	
}
