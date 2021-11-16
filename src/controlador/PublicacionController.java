package controlador;

import java.util.List;

import modelo.Postulacion;
import modelo.Publicacion;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import patrones.ExportadorImagen;
import patrones.FormatoExportar;
import patrones.StrategyImagen;
import vista.VentanaCrearPublicacion;
import vista.VentanaExportarImagenes;
import vista.VentanaVerPostulantes;
import vista.VentanaVerPublicaciones;

public class PublicacionController 
{
	private VentanaCrearPublicacion crearPubVentana;
	private VentanaVerPostulantes verPostulantesVentana;
	private VentanaVerPublicaciones verPublicacionesVentana;
	private ExportadorImagen exportador;
	
	Publicacion modeloPublicacion;
	Postulacion modeloPostulacion;
	private VentanaExportarImagenes exportarImagenesVentana;
	
	public PublicacionController()
	{
		modeloPublicacion = new Publicacion();
		modeloPostulacion = new Postulacion();
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
		verPostulantesVentana.llenarDatos();
		this.verPostulantesVentana.setVisible(true);
	}
	
	public void mostrarVentanaVerPublicaciones()
	{
		this.verPublicacionesVentana.llenarDatosPublicaciones();
		this.verPublicacionesVentana.setVisible(true);
	}
	
	public void crearPublicacion(PublicacionVO pub)
	{
		this.modeloPublicacion.registrarPublicacion(pub);
	}
	
	public VentanaVerPublicaciones getVentanaVerPublicaciones()
	{
		return this.verPublicacionesVentana;
	}
	
	public void setVentanaVerPublicaciones(VentanaVerPublicaciones v)
	{
		this.verPublicacionesVentana = v;
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
	
	public void registrarPostulacion(PublicacionVO pub, PostulacionVO post)
	{
		this.modeloPostulacion.registrarPostulacion(pub, post);
	}

	public void mostrarVentanaExportarImagenes() {
		// TODO Auto-generated method stub
		exportarImagenesVentana = new VentanaExportarImagenes();
		exportarImagenesVentana.setCoordPublicaciones(this);
		this.exportarImagenesVentana.llenarDatosPublicaciones();
		this.exportarImagenesVentana.setVisible(true);
	}
}
