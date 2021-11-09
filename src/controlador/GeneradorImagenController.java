package controlador;

import modelo.Publicacion;
import modelo.vo.PublicacionVO;
import patrones.FormatoExportar;

public class GeneradorImagenController 
{
	public String exportarImagen(PublicacionVO pub, FormatoExportar formato)
	{
		// Encabezado
		String textoImagen = pub.getTitulo() + "\n\n";
				
		// Cuerpo
		textoImagen += "Tareas a Realizar: " + "\n\n";
		
		for (String str : pub.getTareas())
		{
			textoImagen += str + ".\n";
		}
		
		textoImagen += "\n\n";
		textoImagen += "Modalidad de Contrato: " + pub.getModalidadStr() + '\n';
		textoImagen += "Tipo: " + pub.getTipoTrabajoStr() + '\n';
		textoImagen += "Lugar de Trabajo: " + pub.getLugarTrabajo() + '\n';
		textoImagen += "Area: " + pub.getCategoria() + '\n';
		
		textoImagen += "\nRequisitos del puesto: ";
		
		for (String req : pub.getRequisitos())
		{
			textoImagen += req + ".\n";
		}
		
		
		// Pie de Pagina
		textoImagen += "\n";
		
		textoImagen += "Sueldo: " + pub.getSueldo() + "\n\n";
		
		
		
		return "";
	}
}
