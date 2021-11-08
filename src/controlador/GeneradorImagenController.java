package controlador;

import modelo.GeneradorImagen;
import modelo.vo.PublicacionVO;

public class GeneradorImagenController 
{
	private GeneradorImagen generador;
	
	public void generarImagenPublicacion(PublicacionVO pub)
	{
		generador.generarImagen(pub);
	}

	public GeneradorImagen getGenerador() {
		return generador;
	}

	public void setGenerador(GeneradorImagen generador) {
		this.generador = generador;
	}
}
