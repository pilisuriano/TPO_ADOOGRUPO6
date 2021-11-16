package patrones;

import java.util.ArrayList;
import java.util.List;

import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

public class SistemaNotificador
{
	private static SistemaNotificador instancia;
	private Notificador notificador;
	private List<IObservable> observables;
	
	public void agregarObservable(IObservable obs)
	{
		if (!observables.contains(obs))
			observables.add(obs);
	}
	
	public void removerObservable(IObservable obs)
	{
		observables.remove(obs);
	}
	
	public static SistemaNotificador getInstancia()
	{
		if (instancia == null)
			instancia = new SistemaNotificador();
		
		return instancia;
	}
	
	private SistemaNotificador()
	{
		observables = new ArrayList<IObservable>();
		notificador = new Notificador();
	}

	public void enviarNotificacion(Notificacion not, MedioNotificacion medioNotificacion) {
		// TODO Auto-generated method stub
		IEstrategiaNotificable estrategia = null;
		
		switch (medioNotificacion)
		{
			case EMAIL:
			{
				estrategia = new NotificacionEmail();
				break;
			}
				
			default:
				break;
		}
		
		
		this.notificador.cambiarEstrategiaNotificacion(estrategia);
		this.notificador.notificar(not);
	}

	public void notificarPostulacion(PostulacionVO post, PublicacionVO pub) {
		// TODO Auto-generated method stub
		for (IObservable itr : this.observables)
			itr.postulacionRealizada(post, pub);
	}
}
