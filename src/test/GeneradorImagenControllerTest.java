package test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import controlador.GeneradorImagenController;
import modelo.GeneradorImagen;
import modelo.GeneradorImagenJPG;
import modelo.GeneradorImagenPNG;
import modelo.GeneradorImagenSVG;
import modelo.vo.PublicacionVO;

public class GeneradorImagenControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void generarImagenValida() {
		GeneradorImagenController imagenController = new GeneradorImagenController();
		
		PublicacionVO publicacion = new PublicacionVO();
		publicacion.agregarTareas("Programar");
		
		imagenController.generarImagenPublicacion(publicacion);
		
		fail("Not yet implemented");
	}

	@Test
	public void generarImagenJPG() {
		GeneradorImagenController imagenController = new GeneradorImagenController();
		
		GeneradorImagen generador = new GeneradorImagenJPG();
		imagenController.setGenerador(generador);
		
		imagenController.getGenerador();
		fail("Not yet implemented");
	}

	@Test
	public void generarImagenPNG() {
		GeneradorImagenController imagenController = new GeneradorImagenController();
		
		GeneradorImagen generador = new GeneradorImagenPNG();
		imagenController.setGenerador(generador);
		imagenController.getGenerador();
		
		fail("Not yet implemented");
	}

	@Test
	public void generarImagenSVG() {
		GeneradorImagenController imagenController = new GeneradorImagenController();
		
		GeneradorImagen generador = new GeneradorImagenSVG();
		imagenController.setGenerador(generador);
		imagenController.getGenerador();
		
		fail("Not yet implemented");
	}
	
}
