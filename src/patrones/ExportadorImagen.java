package patrones;

import modelo.vo.PublicacionVO;

public class ExportadorImagen 
{
	private IExportable estrategiaExportacion;

	public IExportable getEstrategiaExportacion() {
		return estrategiaExportacion;
	}

	public void setEstrategiaExportacion(IExportable estrategiaExportacion) {
		this.estrategiaExportacion = estrategiaExportacion;
	}
	
	public void exportarPublicacion(PublicacionVO pub)
	{
		this.estrategiaExportacion.exportar(pub);
	}
}
