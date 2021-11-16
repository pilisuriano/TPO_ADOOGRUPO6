package patrones;

import modelo.vo.PublicacionVO;

public class StrategyImagen implements IExportable
{
	@Override
	public void exportar(PublicacionVO pub) {
		// TODO Auto-generated method stub
		System.out.println("Imagen Exportada");
	}
	
}
