package test;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.vo.ReporteVO;

public class ReporteVOTest {
	@Test
	public void ReporteEntreFechas() {
		ReporteVO reporte = new ReporteVO();
		reporte.setCantidad_entre_fechas(5);
		
		assertEquals(5, reporte.getCantidad_entre_fechas());
	}
	
	@Test
	public void ReporteTituloOferta() {
		ReporteVO reporte = new ReporteVO();
		reporte.setTitulo_oferta("Titulo test");
		
		assertEquals("Titulo test", reporte.getTitulo_oferta());
	}
}
