package controlador;

import java.util.List;

import modelo.Publicacion;
import modelo.vo.PublicacionVO;
import vista.VentanaCrearPublicacion;
import vista.VentanaVerPostulantes;
import vista.VentanaVerPublicaciones;

public class PublicacionController 
{
	private VentanaCrearPublicacion crearPubVentana;
	private VentanaVerPostulantes verPostulantesVentana;
	private VentanaVerPublicaciones verPublicacionesVentana;
	
	Publicacion modeloPublicacion;
	
	public PublicacionController()
	{
		modeloPublicacion = new Publicacion();
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
}
