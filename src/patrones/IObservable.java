package patrones;

import modelo.Postulacion;
import modelo.Publicacion;

public interface IObservable {
	public void postulacionRealizada(Postulacion postu, Publicacion pub);
}
