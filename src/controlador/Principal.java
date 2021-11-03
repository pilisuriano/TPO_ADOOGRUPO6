package controlador;

import vista.VentanaReporte;

public class Principal {
	
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
		miVentanaReporte=new VentanaReporte();
		miCoordinador= new ReporteController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaReporte.setCoordinador(miCoordinador);
		
		/*Se establecen relaciones con la clase coordinador*/
		miCoordinador.setMiVentanaReporte(miVentanaReporte);		
				
		miVentanaReporte.setVisible(true);
	}
}
