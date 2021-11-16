package controlador;

import java.util.List;

import modelo.Publicacion;
import modelo.vo.PublicacionVO;
import patrones.ExportadorImagen;
import patrones.FormatoExportar;
import patrones.SistemaNotificador;
import patrones.StrategyImagen;
import vista.VentanaCrearPublicacion;
import vista.VentanaVerPostulantes;
import vista.VentanaVerPublicaciones;

public class PublicacionController 
{
	private VentanaCrearPublicacion crearPubVentana;
	private VentanaVerPostulantes verPostulantesVentana;
	private VentanaVerPublicaciones verPublicacionesVentana;
	private ExportadorImagen exportador;
	
	Publicacion modeloPublicacion;
	
	public PublicacionController()
	{
		modeloPublicacion = new Publicacion();
		exportador = new ExportadorImagen();
	}
	
	public void mostrarVentanaCrearPublicacion()
	{
		crearPubVentana = new VentanaCrearPublicacion();
		crearPubVentana.setCoordinadorPublicaciones(this);
		this.crearPubVentana.setVisible(true);
	}
	
	public void mostrarVentanaVerPostulantes()
	{
		verPostulantesVentana = new VentanaVerPostulantes();
		verPostulantesVentana.setCoordinadorPublicaciones(this);
		
		List<PublicacionVO> pubs = this.modeloPublicacion.getPublicaciones();
		
		verPostulantesVentana.agregarInfoPublicaciones(pubs);
		this.verPostulantesVentana.setVisible(true);
	}
	
	public void mostrarVentanaVerPublicaciones()
	{
		this.verPublicacionesVentana = new VentanaVerPublicaciones();
		this.verPublicacionesVentana.setCoordPublicaciones(this);
		this.verPublicacionesVentana.llenarDatosPublicaciones();
		this.verPublicacionesVentana.setVisible(true);
	}
	
	public void crearPublicacion(PublicacionVO pub)
	{
		this.modeloPublicacion.registrarPublicacion(pub);
	}
	
	public List<PublicacionVO> getPublicacionesActivas()
	{
		return this.modeloPublicacion.getPublicacionesActivas();
	}
	
	public void exportarImagen(PublicacionVO pub, FormatoExportar formato)
	{
		switch (formato)
		{
			case JPG:
			case PNG:
			case SVG:
			{
				StrategyImagen imgStrategy = new StrategyImagen();
				exportador.setEstrategiaExportacion(imgStrategy);
				break;
			}
			
			default:
				break;
		}
		
		exportador.exportarPublicacion(pub);
	}
}
