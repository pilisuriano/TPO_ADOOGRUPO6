package patrones;

import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

public interface IObservable {
	public void postulacionRealizada(PostulacionVO post, PublicacionVO pub);
}
