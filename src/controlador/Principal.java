package controlador;

import vista.VentanaPrincipal;
import vista.VentanaReporte;

public class Principal {
	
	VentanaPrincipal mainWindow;
	CandidatoController coordCandidatos;
	PublicacionController coorPublicacion;
	
	VentanaReporte miVentanaReporte;
	ReporteController miCoordinador;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Principal miPrincipal=new Principal();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		this.mainWindow = new VentanaPrincipal();
		this.coordCandidatos = new CandidatoController();
		this.coorPublicacion = new PublicacionController();
		
		/*Se establecen las relaciones entre clases*/
		
		this.mainWindow.setCandidatoController(coordCandidatos);
		this.mainWindow.setPublicacionesController(coorPublicacion);
		this.mainWindow.setVisible(true);
		
		/*Se establecen relaciones con la clase coordinador*/
		/*miCoordinador.setMiVentanaReporte(miVentanaReporte);		
		miVentanaReporte.setVisible(true);*/
	}
}
