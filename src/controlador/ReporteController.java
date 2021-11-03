package controlador;

import java.util.List;

import modelo.Publicacion;
import modelo.vo.*;
import vista.VentanaReporte;

public class ReporteController {

	private Publicacion publicacion;
	private VentanaReporte miVentanaReporte;
	
	public ReporteController() {
		publicacion = new Publicacion();
	}
	
	public VentanaReporte getMiVentanaReporte() {
		return miVentanaReporte;
	}
	public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
		this.miVentanaReporte = miVentanaReporte;
	}	
	public Publicacion getMiLogica() {
		return publicacion;
	}
	
//////////////////////////////////////////////////////////
	
	public void mostrarVentanaReporte() {
		miVentanaReporte.setVisible(true);
	}	
	
	public ReporteVO getReporteMayorOfertasLaborales(String mes, String anio) {
		ReporteVO res = new ReporteVO();
		List<PublicacionVO> publicaciones = publicacion.getPublicaciones();
		String title = "";
		int mayor = 0;
		for(PublicacionVO ol : publicaciones) {
			int cant = 0;
			for(PostulacionVO postulacion : ol.getPostulaciones()) {
				if(postulacion.getAnio().toString().equals(anio.trim())) {
					if(!mes.trim().equals("") && postulacion.getMes().toString().equals(mes.trim())) {
						cant++;
					}
					else if(mes.trim().equals("")){
						cant++;
					}
				}
			}
			if(cant > mayor) {
				title = ol.getTitulo();
				mayor = cant;
			}
		}
		
		res.setTitulo_oferta(title);
		res.setCantidad_entre_fechas(mayor);
		return res;
	}
}
