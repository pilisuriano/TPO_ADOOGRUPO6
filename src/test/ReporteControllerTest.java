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
		ReporteVO publicacion = reporte.getOfertaMasExigente();
		
		assertThat(publicacion, instanceOf(ReporteVO.class));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void verificarMayorOfertasLaboralesMesValido() {
		ReporteController reporte = new ReporteController();
		ReporteVO reporteGenerado = reporte.getReporteMayorOfertasLaborales("10", "2021");
		
		assertThat(reporteGenerado, instanceOf(ReporteVO.class));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void verificarMayorOfertasLaboralesMesInvalido() {
		ReporteController reporte = new ReporteController();
		ReporteVO reporteGenerado = reporte.getReporteMayorOfertasLaborales("16", "2021");
		
		assertThat(reporteGenerado, instanceOf(ReporteVO.class));
	}
	
	@Test
	public void verificarTrabajoMasAccesible() {
		ReporteController reporte = new ReporteController();
		ReporteVO publicacion = reporte.getOfertaMasAccesible();
		
		assertThat(publicacion, instanceOf(ReporteVO.class));
	}
	
	@Test
	public void obtenerPrimeras2Categorias() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.getTopMCategoriasSeleccionadasPublicaciones(5);
		
		assertEquals(4, publicaciones.size());
	}
	
	@Test
	public void obtenerPrimerasMCategoriasInvalidas() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.getTopMCategoriasSeleccionadasPublicaciones(-10);
		
		assertEquals(0, publicaciones.size());
	}
	
	@Test
	public void obtenerPrimeras999Categorias() {
		ReporteController reporte = new ReporteController();
		List<String> publicaciones = reporte.getTopMCategoriasSeleccionadasPublicaciones(999);
		
		assertEquals(4, publicaciones.size());
	}
	
}
